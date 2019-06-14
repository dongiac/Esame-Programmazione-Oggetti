package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class RadioSet extends Data<RadioStation> implements Parsable<RadioStation>, Filter<RadioSet, Object> {
	public RadioSet(HashSet<RadioStation> set) {
		super.set = set;
	}
	
	@Override
	public void dataParser(Collection<RadioStation> col) {
		try {
			util.parseCSV((HashSet<RadioStation>) col);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
