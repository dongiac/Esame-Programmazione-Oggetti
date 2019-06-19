package com.example.demo1;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

public class Data<T> {
	@Autowired
	ArrayList<T> set; 
	@Autowired
	Utils<T> utils;
	
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data:" + this.set + "]";
	}

	/**
	 * 
	 */
	public Data() {


	}

	public Collection<T> getData() {
		return this.set;
	}

}
