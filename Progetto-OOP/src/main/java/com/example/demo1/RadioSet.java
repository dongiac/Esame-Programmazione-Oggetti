package com.example.demo1;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.springframework.stereotype.Component;
@Component
/**
 * 
 * Class containing all the RadioStation parsed data.
 *
 */
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
		} catch (SecurityException e) {

			e.printStackTrace();
		}
		catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
		 catch (IllegalAccessException e) {
			
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			
			e.printStackTrace();
		} catch (InvocationTargetException e) {
		
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Object compute(ArrayList<RadioStation> src, String fieldName) {
		return utils.mathutils.calculateStats(src, fieldName);
	}
}
