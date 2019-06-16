package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashSet;

public class FilterUtils<T> {

	public static boolean check(Object value, String operator, Object th) {
		System.out.println("value: " +value.getClass().getName());
		System.out.println("th: " + th.getClass().getName());
		
		try {
			double thC = Double.parseDouble((String)th);
			System.out.println("il valore Ã¨ un numero!");
			
			Double valuec = ((Number) value).doubleValue();
			if (operator.equals("=="))
				return value.equals(th);
			else if (operator.equals(">"))
				return valuec > thC;
			else if (operator.equals("<"))
				return valuec < thC;
		}catch (NumberFormatException e)
			{ 
			System.out.println("il valore Ã¨ una stringa!");
		return value.equals(th);
			}

		System.out.println("tale oggetto non soddisfa i requisiti");
		return false;
	}

	public Collection<T> select(HashSet<T> src, String fieldName, String operator, Object value) {
		
		Collection<T> out = new HashSet<T>();
		for (T item : src) {
			try {
				Method m = item.getClass()
						.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
				try {
					Object tmp = m.invoke(item);
					System.out.println("ho invocato il get");
					if (FilterUtils.check(tmp, operator, value))
						out.add(item);
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return out;
	}

}
