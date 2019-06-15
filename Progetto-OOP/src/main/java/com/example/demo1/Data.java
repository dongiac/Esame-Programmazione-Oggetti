package com.example.demo1;

import java.util.Collection;

public abstract class Data<T> {
	Collection<T> set; 

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

	public abstract void parseData();

}
