package com.example.demo1;

import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioStation, Object> {
	@Autowired
	FilterUtils<RadioStation> utilities;
	
	
	public RadioSet() {
		
	}
	
	
	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
	}

	@Override
	public HashSet<RadioStation> filterField(Collection<RadioStation> set, String fieldName, String operator,
			Object value) {
		// TODO Auto-generated method stub
		return  (HashSet<RadioStation>)utilities.select((HashSet<RadioStation>)set, fieldName, operator, value);
	}

	/*@Override
	public void parseData() {
		try {
			Utils.parseCSV((HashSet<RadioStation>) this.set);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} */
}
