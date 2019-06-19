package com.example.demo1;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.json.simple.JSONObject;

public class MathUtils<T> { 
	public Object calculateStats(Collection<T> src, String fieldName) {
		JSONObject m1 = new JSONObject();
		m1.put("field",fieldName);
		ArrayList<Double> tmp = new ArrayList<Double>();
		for (T item : src) {
			try {
				Method m = item.getClass()
						.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
				try {
					if (((double) (m.invoke(item))) != 0)
						tmp.add((Double) (m.invoke(item)));

				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		m1.put("avg", average(tmp));
		m1.put("min",min(tmp));
		m1.put("max",max(tmp));
		m1.put("std", std(tmp));
		m1.put("count", count(tmp));
		return m1;
	}
	

	public static double average(Collection<Double> src) {
		double tot = 0;

		for (Double item : src) {
			tot = tot + ((double) item.doubleValue());
		}
		return (tot / (src.size()));
	}

	public static double min(Collection<Double> src) {
		return Collections.min(src);
	}

	public static double max(Collection<Double> src) {
		return Collections.max(src);
	}

	public static double std(Collection<Double> src) {
		int n = src.size();
		double val = 0;
		double media = average(src);
		for (Double item : src) {
			val = val + Math.pow((item - media), 2);
		}
		return (Math.sqrt(val / n));
	}
	public static int count(Collection<Double> src) {
		int count = 0;
		for(Double item : src) {
			count++;
		}
		return count;
	}
	
	public Object wordsCount(Collection<T> src, String word) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int countContain = 0;
		int countEquals = 0;
		String o;
		Class c = Class.forName("com.example.demo1.RadioStation");
		Method[] m  = c.getDeclaredMethods();
		for(T item : src) {
			for(int i = 0; i<m.length; i++) {
				if(m[i].getName().startsWith("get")) {
				o = (m[i].invoke(item, null)).toString();
				if(o.contains(word)) //non viene effettuato il controllo se il metodo get apposito non esiste.
					countContain++;
				if(o.equals(word))
					countEquals++;
				}
			}
		}
		//deve ciclare tutti gli elementi presi con getattributo1,2...
		JSONObject object = new JSONObject();
		object.put("word", word);
		object.put("count contains", countContain);
		object.put("count equals", countEquals);
		return object;
	}
}
