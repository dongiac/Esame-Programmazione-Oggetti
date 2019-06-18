package com.example.demo1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Controller1 {
	ApplicationContext ctx1 = new AnnotationConfigApplicationContext(SystemConfig.class);
	RadioSet rs = ctx1.getBean(RadioSet.class);
	MetaSet ms = ctx1.getBean(MetaSet.class); // gli oggetti vengono istanziati, iniettati, e i relativi dati recuperati
												// con get

	@PostMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet(@RequestBody FieldParamAll filterParams) throws IOException {
		return rs.filterField(filterParams);
	}

	@GetMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet() throws IOException {
		return (ArrayList<RadioStation>) rs.getData();
	}

	@RequestMapping("/metadata")
	@ResponseBody
	public HashSet<MetaData> getMetaSet() throws IOException, ClassNotFoundException {
		return (HashSet<MetaData>) ms.getData();
	}

	@RequestMapping("/stats")
	public MathStatsResults getMathStats(@RequestParam("fieldName") String fieldName) {
		return rs.compute(fieldName);
	}
	
	
}
