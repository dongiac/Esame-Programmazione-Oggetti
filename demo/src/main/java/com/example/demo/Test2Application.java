package com.example.demo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.*;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.metadata.ClassMetadata;

@SpringBootApplication
public class Test2Application {

	public static void main(String[] args) throws Exception {
		HashSet<RadioStation> set = new HashSet<RadioStation>();
		
		String url = "https://www.dati.gov.it/api/3/action/package_show?id=7fae4996-02e1-4a80-8794-9ec22454041b";
		String data = "";
		String csvUrl;
		data = CSV.jsonToString(url); // Converte il
		csvUrl = CSV.getCSVUrl(data);
		CSV.download(csvUrl); // scarica il csv
		
		SpringApplication.run(Test2Application.class, args);

	}

}
