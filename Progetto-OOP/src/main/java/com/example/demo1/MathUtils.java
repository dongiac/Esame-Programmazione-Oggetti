package com.example.demo1;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.json.simple.JSONObject;
/**
 * 
 * Class containing all the methods used for math and word stats.
 *
 * @param <T> Class T object we want to analyze.
 */
public class MathUtils<T> {
	
	/**
	 * This method calulates all the math stats of a Collection of T class Objects, given a certain fieldName we want to analyze.
	 * @param src Collection of T class Objects.
	 * @param fieldName fieldName we want to analyze and from which we want to get stats.
	 * @return Object containing all the results of the math stats.
	 */
	public Object calculateStats(Collection<T> src, String fieldName) {
		for(T item : src) {
			if (item instanceof JSONObject) { //gli errori vengono memorizzati e passati sotto forma di JSONObject, quindi se ve ne sono, vengono riportati
				return item;
			}
		}
		JSONObject m1 = new JSONObject();
		m1.put("field", fieldName);
		System.out.println("il numero di valori filtrati è " +src.size());
		ArrayList<Double> tmp = new ArrayList<Double>();
		if(src.size() == 0)
			m1.put("Errore", "Non ci sono oggetti che soddisfano i requisiti inseriti");
		for (T item : src) {
			try {
				Method m = item.getClass()
						.getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1), null);
				try {
					if (((double) (m.invoke(item))) != 0)
						tmp.add((Double) (m.invoke(item)));

				} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
					e.printStackTrace();
				}
				
				m1.put("avg", average(tmp));
				m1.put("min", min(tmp));
				m1.put("max", max(tmp));
				m1.put("std", std(tmp));
				m1.put("count", count(tmp));
				
			} catch (NoSuchMethodException e) {
				m1.put("Errore", "Il campo inserito e/o l'operatore non sono validi test");
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("ritorno m1");
		return m1;
	}
	/**
	 * Calculates the average from a set of numbers (Double).
	 * @param src Collection we want to analyze.
	 * @return Result.
	 */
	public static double average(Collection<Double> src) {
		double tot = 0;

		for (Double item : src) {
			tot = tot + ((double) item.doubleValue());
		}
		return (tot / (src.size()));
	}
	/**
	 * Calculates the min value from a set of numbers.
	 * @param src Collection we want to analyze.
	 * @return Result.
	 */
	public static double min(Collection<Double> src) {
		return Collections.min(src);
	}
	/**
	 * Calculates the max value from a set of numbers.
	 * @param src Collection we want to analyze.
	 * @return Result.
	 */
	public static double max(Collection<Double> src) {
		return Collections.max(src);
	}
	/**
	 * Calculates the standard deviation value from a set of numbers.
	 * @param src Collection we want to analyze.
	 * @return Result.
	 */
	public static double std(Collection<Double> src) {
		int n = src.size();
		double val = 0;
		double media = average(src);
		for (Double item : src) {
			val = val + Math.pow((item - media), 2);
		}
		return (Math.sqrt(val / n));
	}
	/**
	 * Counts the elements in the collection.
	 * @param src Collection we want to analyze.
	 * @return Result.
	 */
	public static int count(Collection<Double> src) {
		int count = 0;
		for (Double item : src) {
			count++;
		}
		return count;
	}
	/**
	 * Counts the words contained or equal to a data set.
	 * @param src The data set we want to analyze.
	 * @param word The word we want to calculate the occurrence.
	 * @return Results of the stats.
	 * @throws ClassNotFoundException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	public Object wordsCount(Collection<T> src, String word)
			throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		int countContain = 0;
		int countEquals = 0;
		String o;
		Class c = Class.forName("com.example.demo1.RadioStation");
		Method[] m = c.getDeclaredMethods();
		for (T item : src) {
			for (int i = 0; i < m.length; i++) {
				if (m[i].getName().startsWith("get")) {
					o = (m[i].invoke(item, null)).toString();
					if (o.contains(word)) // non viene effettuato il controllo se il metodo get apposito non esiste.
						countContain++;
					if (o.equals(word))
						countEquals++;
				}
			}
		}
		JSONObject object = new JSONObject();
		object.put("word", word);
		object.put("count contains", countContain);
		object.put("count equals", countEquals);
		return object;
	}
}
