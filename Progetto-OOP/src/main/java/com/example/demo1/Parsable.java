package com.example.demo1;

import java.util.Collection;

public interface Parsable<T> {
	public abstract void dataParser(Collection<T> col);
}