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
		Utils.download(csvUrl); // scarica il csv */
		RadioStation a = new RadioStation();
		a.setAddress("skrrt");
		RadioStation b = new RadioStation();
		b.setAddress("skrrt");
		RadioStation c = new RadioStation();
		c.setAddress("skrrt");
		HashSet<RadioStation> setprova = new HashSet<RadioStation>();
		setprova.add(a);
		setprova.add(b);
		setprova.add(c);
		RadioSet a1 = new RadioSet();
		a1.set.add(a);
		a1.set.add(b);
		a1.set.add(c);
		System.out.println(a1.getData());
		//ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		//RadioSet a = ctx.getBean(RadioSet.class);
		
		/*ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		RadioSet rs = ctx.getBean(RadioSet.class);
		Utils.parseCSV((HashSet<RadioStation>) rs.set);
		System.out.println(rs.toString()); */
		
		SpringApplication.run(ProgettoOopApplication.class, args);
	}

}
