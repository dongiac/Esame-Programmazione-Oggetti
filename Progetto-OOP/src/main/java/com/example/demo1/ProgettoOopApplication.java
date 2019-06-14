package com.example.demo1;

import java.util.HashSet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {

		String url = "https://www.dati.gov.it/api/3/action/package_show?id=7fae4996-02e1-4a80-8794-9ec22454041b";
		String data = "";
		String csvUrl;
		data = Utils.jsonToString(url); // Converte il
		csvUrl = Utils.getCSVUrl(data);
		Utils.download(csvUrl); // scarica il csv
		SpringApplication.run(ProgettoOopApplication.class, args);
	}

}
