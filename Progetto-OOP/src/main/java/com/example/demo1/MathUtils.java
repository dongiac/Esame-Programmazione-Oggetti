package com.example.demo1;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MathUtils<T> { 
	public MathStatsResults calculateStats(Collection<T> src, String fieldName) {
		MathStatsResults m1 = new MathStatsResults();
		m1.setField(fieldName);
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
		m1.setAvg(average(tmp));
		m1.setMin(min(tmp));
		m1.setMax(max(tmp));
		m1.setStd(std(tmp));
		m1.setCount(count(tmp));
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
			System.out.println(val);
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
	
}
