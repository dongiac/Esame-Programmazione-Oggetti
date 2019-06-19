package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils<T> {
	@Autowired
	public
	FilterUtils<T> filterutils;
	@Autowired
	public
	MathUtils<T> mathutils;
	ParseUtils parseutils; //essendo fatta di metodi static non necessita di essere istanziata...
}
