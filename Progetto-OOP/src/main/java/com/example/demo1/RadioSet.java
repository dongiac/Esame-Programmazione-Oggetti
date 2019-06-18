package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioStation> {
	public RadioSet() {

	}

	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
	}

	@Override
	public HashSet<RadioStation> filterField(Collection<RadioStation> set, FieldParamAll filterParam) {
		try {
			return (HashSet<RadioStation>) this.utils.select((HashSet<RadioStation>) set, filterParam.getFieldName(),
					filterParam.fieldParam.getOperator(), filterParam.fieldParam.getValue());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * @Override public void parseData() { try {
	 * Utils.parseCSV((HashSet<RadioStation>) this.set); } catch (IOException e) {
	 * // TODO Auto-generated catch block e.printStackTrace(); } }
	 */
}
