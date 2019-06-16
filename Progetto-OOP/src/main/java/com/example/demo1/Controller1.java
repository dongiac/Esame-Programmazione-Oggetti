package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class Controller1 {
	ApplicationContext ctx1 = new AnnotationConfigApplicationContext(SystemConfig.class);
	RadioSet rs = ctx1.getBean(RadioSet.class);
	MetaSet ms = ctx1.getBean(MetaSet.class); // gli oggetti vengono istanziati, iniettati, e i relativi dati recuperati
												// con get

	@RequestMapping("/data")
	@ResponseBody
	public HashSet<RadioStation> getRadioSet() throws IOException {
		return (HashSet<RadioStation>) rs.getData();
	} // la costruzione
		// e parsing avvengono all'avvio

	@RequestMapping("/metadata")
	@ResponseBody
	public HashSet<MetaData> getMetaSet() throws IOException, ClassNotFoundException {

		return (HashSet<MetaData>) ms.getData();
	}

	@RequestMapping("/filtraggio")
	@ResponseBody
	public HashSet<RadioStation> filtraggio(@RequestParam("fieldName") String fieldName,
			@RequestParam("operatore") String operatore, @RequestParam("valore") Object value) {
		return (HashSet<RadioStation>) rs.filterField(rs.set, fieldName, operatore, value);
	}

}
