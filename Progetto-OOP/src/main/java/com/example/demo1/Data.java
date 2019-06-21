package com.example.demo1;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * Generic class that contains data referred to T class objects and utils.
 *
 * @param <T> Class objects type in the data set.
 */
public class Data<T> {
	/**
	 * Generic ArrayList of T objects which represents the whole parsed data set.
	 */
	@Autowired
	ArrayList<T> set; 
	/**
	 * Generic Utils for T class objects.
	 */
	@Autowired
	Utils<T> utils;
	
	@Override
	public String toString() {
		return "Data:" + this.set + "]";
	}

	/**
	 * Constructor
	 */
	public Data() {


	}
	/**
	 * Returns the all the data from the data set
	 * @return Data from the data set
	 */
	public Collection<T> getData() {
		return this.set;
	}

}
