package com.example.demo1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Spring boot application class containing the main class.
 * @author 
 *
 */
@SpringBootApplication
public class ProgettoOopApplication {

	public static void main(String[] args) throws Exception {
		//String url = "https://www.dati.gov.it/api/3/action/package_show?id=7fae4996-02e1-4a80-8794-9ec22454041b";
		String url = args[0];
		String data = "";
		String csvUrl;
		data = ParseUtils.jsonToString(url);
		csvUrl = ParseUtils.getCSVUrl(data);
		ParseUtils.download(csvUrl);
		SpringApplication.run(ProgettoOopApplication.class, args);
	} 

}
