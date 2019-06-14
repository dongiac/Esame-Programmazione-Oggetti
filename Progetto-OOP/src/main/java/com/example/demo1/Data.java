package com.example.demo1;

import java.util.Collection;

public abstract class Data<T> {
	Collection<T> set;
	Utils util;
	
	public Collection<T> getData() {
		return set; //sarà sufficiente fare un casting nel main o dove serve (si spera basti kek)
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Data:" + set + "]";
	}
	
	
}
