package com.example.demo1;

import java.util.Collection;

public abstract class Data<T> {
	Collection<T> set; // bisogna far ereditare collection<T> ed eliminare i set di Radio e MetaData
						// per poter usare getData() ovviamente...

	public Collection<T> getData() {
		return this.set; // sarà sufficiente fare un casting nel main o dove serve (si spera basti kek)
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
