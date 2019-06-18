package com.example.demo1;

import java.util.Collection;
import java.util.HashSet;

public interface Filter<E> {
	abstract HashSet<E> filterField(Collection<E> src, FieldParamAll filterParams);
}
