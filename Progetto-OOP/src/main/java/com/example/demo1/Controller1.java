package com.example.demo1;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@EnableAutoConfiguration
public class Controller1 {
	ApplicationContext ctx1 = new AnnotationConfigApplicationContext(SystemConfig.class);
	RadioSet rs = ctx1.getBean(RadioSet.class);
	MetaSet ms = ctx1.getBean(MetaSet.class); // gli oggetti vengono istanziati, iniettati, e i relativi dati recuperati
											// con get

	@PostMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet(@RequestBody JSONObject object) throws IOException {
		Gson g = new GsonBuilder().create();
		FieldParamAll field = g.fromJson(object.toJSONString(), FieldParamAll.class);
		System.out.println(field.toString());
		return rs.filterField(field);
	}

	@GetMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet() throws IOException {
		
		return (ArrayList<RadioStation>) rs.getData();
	}

	@RequestMapping("/metadata")
	@ResponseBody
	public ArrayList<MetaData> getMetaSet() throws IOException, ClassNotFoundException {
		return (ArrayList<MetaData>) ms.getData();
	}

	@RequestMapping("/stats")
	public Object getMathStats(@RequestParam("fieldName") String fieldName) {
		return rs.compute((ArrayList<RadioStation>)rs.getData(), fieldName);
	}
	
	@PostMapping("/stats")
	public Object getFilteredMathStats(@RequestBody JSONObject object) {
		Gson g = new GsonBuilder().create();
		FieldParamAll field = g.fromJson(object.toJSONString(), FieldParamAll.class);
		return rs.compute(rs.filterField(field), field.getFieldName());
	}
	
	@RequestMapping("/wordstats")
	public Object getWordsStats(@RequestParam("word") String word) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return  rs.utils.mathutils.wordsCount(rs.getData(), word);
	}
	
	
}
