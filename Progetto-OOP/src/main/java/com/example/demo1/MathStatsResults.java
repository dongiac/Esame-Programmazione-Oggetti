package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class MathStatsResults {
	String field;
	double avg;
	double min;
	double max;
	double std;
	int count;

	/**
	 * @param util
	 * @param field
	 * @param avg
	 * @param min
	 * @param max
	 * @param std
	 * @param count
	 */
	public MathStatsResults(String field, double avg, double min, double max, double std, int count) {
		this.field = field;
		this.avg = avg;
		this.min = min;
		this.max = max;
		this.std = std;
		this.count = count;
	}

	/**
	 * 
	 */
	public MathStatsResults() {
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @return the avg
	 */
	public double getAvg() {
		return avg;
	}

	/**
	 * @return the min
	 */
	public double getMin() {
		return min;
	}

	/**
	 * @return the max
	 */
	public double getMax() {
		return max;
	}

	/**
	 * @return the std
	 */
	public double getStd() {
		return std;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	/**
	 * @param avg the avg to set
	 */
	public void setAvg(double avg) {
		this.avg = avg;
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(double min) {
		this.min = min;
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(double max) {
		this.max = max;
	}

	/**
	 * @param std the std to set
	 */
	public void setStd(double std) {
		this.std = std;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public void compute(Collection<RadioStation> src, String fieldName) {
		ArrayList<Double> tmp = new ArrayList<Double>();
		for (RadioStation item : src) {
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
		setAvg(average(tmp));
		setMin(min(tmp));
		setMax(max(tmp));
		setStd(std(tmp));
		setCount(count(tmp));
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
