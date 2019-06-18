package com.example.demo1;

import java.util.HashSet;

public interface Filter<E> {
	abstract HashSet<E> filterField(FieldParamAll filterParams);
}
