package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class RadioSet extends Data<RadioStation> implements Filter<RadioSet, Object> {
	
	 public RadioSet() {
		 super.set = new HashSet<RadioStation>();
	 }
	
	
	@Override
	public void parseData() {
		try {
			Utils.parseCSV((HashSet<RadioStation>) super.set);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
