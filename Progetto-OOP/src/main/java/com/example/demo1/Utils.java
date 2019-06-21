package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/**
 * 
 * This class contains miscellaneous utilities such as: filter, stats, and parsing.
 * All the utilities contained are general and must be parameterized
 * @param <T> Class object we want to manipulate.
 */
@Component
public class Utils<T> {
	/**
	 * Filter utility @param <T> Class object that will get filtered.
	 */
	@Autowired
	public
	FilterUtils<T> filterutils;
	/**
	 * Math utility @param <T> Class objects we want to get stats from.
	 */
	@Autowired
	public
	MathUtils<T> mathutils;
	/**
	 * Parse utility
	 */
	ParseUtils parseutils; 
}
