package com.example.demo1;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;


public abstract class Data<T> {
	@Autowired
	HashSet<T> set; 

	public Collection<T> getData() {
		return this.set; // sarà sufficiente fare un cast dove serve
	}

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

	public abstract void parseData();

}
