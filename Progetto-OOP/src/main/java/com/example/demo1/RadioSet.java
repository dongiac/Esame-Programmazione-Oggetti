package com.example.demo1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Component;
@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioStation>, Stats<RadioStation> {
	public RadioSet() {
		
	}

	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
	}

	@Override
	public ArrayList<RadioStation> filterField(FieldParamAll filterParam) {
		try {
			return (ArrayList<RadioStation>) utils.filterutils.select(this.set, filterParam.getFieldNames(), filterParam.getFieldName(),
					filterParam.fieldParam.getOperator(), filterParam.fieldParam.getValues(), filterParam.fieldParam.getValue());
		} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public Object compute(ArrayList<RadioStation> src, String fieldName) {
		return utils.mathutils.calculateStats(src, fieldName);
	}
}
