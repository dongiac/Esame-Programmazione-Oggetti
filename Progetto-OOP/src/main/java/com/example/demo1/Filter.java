package com.example.demo1;

import java.util.ArrayList;

public interface Filter<E> {
	abstract ArrayList<E> filterField(FieldParamAll filterParams);
}
