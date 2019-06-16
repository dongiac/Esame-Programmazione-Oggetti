package com.example.demo1;

import java.util.Collection;

public interface Filter<E, T> {
	abstract Collection<E> filterField(Collection<E> set, String fieldName, String operator, T value);
}
