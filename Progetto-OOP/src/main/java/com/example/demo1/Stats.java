package com.example.demo1;

import java.util.ArrayList;
import java.util.Collection;

public interface Stats<T> {
	public Object compute(ArrayList<T> src, String fieldName);
}
