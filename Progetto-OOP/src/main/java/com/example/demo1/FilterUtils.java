package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

public class FilterUtils<T> {

	public static boolean check(Object value, String operator, Object th) {

		try {
			double thC = Double.parseDouble(th.toString());
			Double valuec = ((Number) value).doubleValue();
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
		} catch (NumberFormatException e) {
			return value.equals(th);
		}
		return false;
	}

	public Collection<T> select(Collection<T> src, String[] fieldNames, String fieldName, String operator,
			Object[] values, Object value) throws NoSuchMethodException, SecurityException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {
		Collection<T> out = new ArrayList<T>();
		;
		switch (operator) {
		case "$or":
			for (T item : src) {
				if (checkSpecsOR(item, fieldNames, values))
					out.add(item);
			}
			return out;

		case "$not":
			for (T item : src) {
				if (checkSpecsNOT(item, fieldName, value))
					out.add(item);
			}
			return out;

		case "$bt":
			for (T item : src) {
				if (checkSpecsBT(item, fieldName, values))
					out.add(item);
			}
			return out;

		case "$gt":
			for (T item : src) {
				if (checkSpecsGT(item, fieldName, value))
					out.add(item);
			}
			return out;
		}
		return null;
	}

	private boolean checkSpecsGT(T item, String fieldName, Object value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = item.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
				null);
		Object tmp = m.invoke(item, null);
		System.out.println(tmp.toString());
		System.out.println(value);
		if (Double.parseDouble(tmp.toString()) > Double.parseDouble(value.toString()))
			return true;
		else
			return false;

	}

	private boolean checkSpecsBT(T item, String fieldName, Object[] values) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = item.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
				null);
		Object tmp = m.invoke(item, null);
		if ((Double.parseDouble(tmp.toString()) < Double.parseDouble(values[1].toString()))
				&& (Double.parseDouble(tmp.toString())) > (Double.parseDouble(values[0].toString())))
			return true;
		else
			return false;
	}

	private boolean checkSpecsNOT(T item, String fieldName, Object value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = item.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
				null);
		Object tmp = m.invoke(item, null);
		if ((tmp.toString().equals(value.toString())))
			return false;
		else
			return true;
	}

	private boolean checkSpecsOR(T item, String fieldNames[], Object[] values) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m0 = item.getClass()
				.getMethod("get" + fieldNames[0].substring(0, 1).toUpperCase() + fieldNames[0].substring(1), null);
		Method m1 = item.getClass()
				.getMethod("get" + fieldNames[1].substring(0, 1).toUpperCase() + fieldNames[1].substring(1), null);
		Object tmp0 = m0.invoke(item, null);
		Object tmp1 = m1.invoke(item, null);
		System.out.println(tmp0.toString());
		System.out.println(tmp1.toString());
		System.out.println(values[0].toString());
		System.out.println(values[1].toString());
		if ((tmp0.toString().equals(values[0].toString())) || (tmp1.toString().equals(values[1].toString())))
			return true;
		else
			return false;
	}

}
