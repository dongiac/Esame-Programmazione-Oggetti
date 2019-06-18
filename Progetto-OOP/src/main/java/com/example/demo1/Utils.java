package com.example.demo1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Utils<T> {
	@Autowired
	FilterUtils<T> filterutils;
	@Autowired
	MathUtils<T> mathutils;
	ParseUtils parseutils;
}
