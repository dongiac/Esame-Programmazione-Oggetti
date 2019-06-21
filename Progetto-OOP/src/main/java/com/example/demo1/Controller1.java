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

/**
 * 
 * Controller responsible for REST requests
 *
 */
@RestController
@EnableAutoConfiguration
public class Controller1 {
	ApplicationContext ctx1 = new AnnotationConfigApplicationContext(SystemConfig.class);
	/**
	 * Gets the RadioSet bean parsing the data at startup
	 */
	RadioSet rs = ctx1.getBean(RadioSet.class);
	/**
	 * Gets the MetaSet bean parsing the metadata at startup
	 */
	MetaSet ms = ctx1.getBean(MetaSet.class);

	/**
	 * This method filters the RadioStation data set with a POST request containing
	 * the necessary parameters which are put in a JSONObject class object. The
	 * attributes in the JSONObject class object must be coherent with the class
	 * FieldParamAll, otherwise, will be returned an exception. If some attributes
	 * are missing or wrong, will be returned a JSONObject object containing info
	 * about the error.
	 * 
	 * @param object Object that will contain parameters for the data filter.
	 * @return Returns a filtered ArrayList of RadioStation Objects.
	 * @throws IOException
	 */
	@PostMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet(@RequestBody JSONObject object) throws IOException {
		Gson g = new GsonBuilder().create();
		FieldParamAll field = g.fromJson(object.toJSONString(), FieldParamAll.class);
		return rs.filterField(field);
	}

	/**
	 * This method allows to get after a GET request a ArrayList of RadioStation
	 * objects containing the entire Data set.
	 * 
	 * @return ArrayList of RadioStation class objects containing the parsed data
	 *         set.
	 * @throws IOException
	 */
	@GetMapping("/data")
	@ResponseBody
	public ArrayList<RadioStation> getRadioSet() throws IOException {

		return (ArrayList<RadioStation>) rs.getData();
	}

	/**
	 * This method allows to get after a GET request a ArrayList of MetaData class
	 * objects containing all the metadata.
	 * 
	 * @return ArrayList of MetaData class objects containing the metadata.
	 * @throws IOException
	 * @throws ClassNotFoundException
	 */

	@RequestMapping("/metadata")
	@ResponseBody
	public ArrayList<MetaData> getMetaSet() throws IOException, ClassNotFoundException {
		return (ArrayList<MetaData>) ms.getData();
	}

	/**
	 * This method allows to get math stats for a certain field name (fieldName)
	 * after a GET request.
	 * 
	 * @param fieldName The name of the field we want to get stats from
	 * @return Object containing all the math stats for the field
	 */

	@RequestMapping("/stats")
	public Object getMathStats(@RequestParam("fieldName") String fieldName) {
		return rs.compute((ArrayList<RadioStation>) rs.getData(), fieldName);
	}

	/**
	 * This method filters the RadioStation data set a with a POST request
	 * containing the necessary parameters which are put in a JSONObject class
	 * object.
	 * 
	 * @param object The object that will contain the parameters.
	 * @return Object containing the stats calculated from the filtered data set.
	 * @throws NoSuchMethodException
	 */
	@PostMapping("/stats")
	public Object getFilteredMathStats(@RequestBody JSONObject object) throws NoSuchMethodException {
		Gson g = new GsonBuilder().create();

		FieldParamAll field = g.fromJson(object.toJSONString(), FieldParamAll.class);

		ArrayList<RadioStation> rsf = rs.filterField(field);

		return rs.compute(rsf, field.getFieldName());

	}

	/**
	 * This method calculates all the recurrences of word which contain, or equal, a
	 * certain word passed with a GET request.
	 * 
	 * @param word The word which we want to calculate the recurrence.
	 * @return Object containing the word stats.
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */

	@RequestMapping("/wordstats")
	public Object getWordsStats(@RequestParam("word") String word)
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return rs.utils.mathutils.wordsCount(rs.getData(), word);
	}

}
