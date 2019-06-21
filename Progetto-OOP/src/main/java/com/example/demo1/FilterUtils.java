package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;

import org.json.simple.JSONObject;
/**
 * 
 * This class contains the methods for filtering and selecting objects from a data set of T class objects.
 *
 * @param <T> Class of object we want to filter.
 */
public class FilterUtils<T> {
	/**
	 * This method selects a src Collection of T class objects we want to filter with certain parameters.
	 * Check the class FieldParamAll for info about the parameters.
	 * @param src The collection of objects we want to select.
	 * @param fieldNames 
	 * @param fieldName 
	 * @param operator 
	 * @param values
	 * @param value
	 * @return ArrayList of T class objects that match the parameters chosen.
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NoSuchMethodException
	 */
	public Collection<T> select(Collection<T> src, String[] fieldNames, String fieldName, String operator,
			Object[] values, Object value) throws SecurityException, IllegalAccessException, IllegalArgumentException,
			InvocationTargetException, NoSuchMethodException {
		Collection<T> out = new ArrayList<T>();
		try {
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
				try {
					for (T item : src) {
						if (checkSpecsBT(item, fieldName, values))
							out.add(item);
					}

					return out;
				} catch (NumberFormatException e) {
					JSONObject err = new JSONObject();
					Collection errList = new ArrayList();
					err.put("Errore", "Assicurarsi di aver inserito esclusivamente numeri nel campo value(s)");
					errList.add(err);
					return errList;
				} catch(ArrayIndexOutOfBoundsException e) {
					JSONObject err = new JSONObject();
					Collection errList = new ArrayList();
					err.put("Errore", "Assicurarsi di aver inserito due elementi nel campo value(s)");
					errList.add(err);
					return errList;
				}
			case "$gt":
				try {
					for (T item : src) {
						if (checkSpecsGT(item, fieldName, value))
							out.add(item);
						System.out.println(checkSpecsGT(item,fieldName,value));
						
					}
					return out;
				} catch (NumberFormatException e) {
					JSONObject err = new JSONObject();
					Collection errList = new ArrayList();
					err.put("Errore", "Assicurarsi di aver inserito esclusivamente numeri");
					errList.add(err);
					return errList;
				}

			default:

				System.out.println("Nessun operatore corrispondente");
				JSONObject err = new JSONObject();
				Collection errList = new ArrayList();
				err.put("Errore", "Operatore non ammesso");
				errList.add(err);
				return errList;
			}
		} catch (NoSuchMethodException e) {
			JSONObject err = new JSONObject();
			Collection errList = new ArrayList();
			err.put("Errore", "Campo inesistente");
			errList.add(err);
			return errList;
		} 

	}
	/**
	 * This method checks if the value of the data set is greater than a value passed as parameter.
	 * Check FieldParamAll for info about the used parameters.
	 * @param item
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private boolean checkSpecsGT(T item, String fieldName, Object value) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method m = item.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
				null);
		Object tmp = m.invoke(item, null);
		if (Double.parseDouble(tmp.toString()) > Double.parseDouble(value.toString()))
			return true;
		else
			return false;

	}
	/**
	 * This method checks if the value of the data set is between two values passed as parameters.
	 * Check FieldParamAll for more info about the parameters.
	 * @param item
	 * @param fieldName
	 * @param values
	 * @return
	 * @throws NoSuchMethodException
	 * @throws ArrayIndexOutOfBoundsException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 * @throws NumberFormatException
	 */
	private boolean checkSpecsBT(T item, String fieldName, Object[] values) throws NoSuchMethodException,ArrayIndexOutOfBoundsException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NumberFormatException {
		Method m = item.getClass().getMethod("get" + fieldName.substring(0, 1).toUpperCase() + fieldName.substring(1),
				null);
		Object tmp = m.invoke(item, null);
		if (values.length > 2) throw new ArrayIndexOutOfBoundsException();
		if ((Double.parseDouble(tmp.toString()) < Double.parseDouble(values[1].toString()))
				&& (Double.parseDouble(tmp.toString())) > (Double.parseDouble(values[0].toString())))
			return true;
		else
			return false;
	}
	/**
	 * This method checks if the value of the data set is not equal to the value passed as parameter.
	 * Check FieldParamAll for more info about the parameters.
	 * @param item
	 * @param fieldName
	 * @param value
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
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
	/**
	 * This method checks if a T class objects equals an array of values using a or operator.
	 * Check FieldParamAll for more info about the parameters.
	 * @param item
	 * @param fieldNames
	 * @param values
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 * @throws InvocationTargetException
	 */
	private boolean checkSpecsOR(T item, String fieldNames[], Object[] values) throws NoSuchMethodException,
			SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {

		ArrayList<Method> methodArrayList = new ArrayList<Method>(fieldNames.length);
		Method m;
		for (int i = 0; i < fieldNames.length; i++) {
			m = item.getClass()
					.getMethod("get" + fieldNames[i].substring(0, 1).toUpperCase() + fieldNames[i].substring(1), null);
			methodArrayList.add(m);
		}

		ArrayList<Object> tmpArrayList = new ArrayList<Object>();

		for (int i = 0; i < methodArrayList.size(); i++) {
			tmpArrayList.add(methodArrayList.get(i).invoke(item, null));
			if ((((tmpArrayList.get(i)).toString()).equals(values[i].toString())))
				return true;
		}
		return false;

	}

}
