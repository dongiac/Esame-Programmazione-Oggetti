package com.example.demo1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioStation>, Stats {
	public RadioSet() {

	}

	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
	}

	@Override
	public ArrayList<RadioStation> filterField(FieldParamAll filterParam) {
		try {
			return (ArrayList<RadioStation>) utils.filterutils.select(this.set, filterParam.getFieldName(),
					filterParam.fieldParam.getOperator(), filterParam.fieldParam.getValue());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public MathStatsResults compute(String fieldName) {
		return utils.mathutils.calculateStats(this.set, fieldName);
	}
}
