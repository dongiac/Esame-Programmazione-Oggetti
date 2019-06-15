package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class RadioSet extends Data<RadioStation> implements Filter<RadioSet, Object> {
	public RadioSet() throws IOException {
		System.out.println("ho parsato e caricati i dati...");
		super.set = new HashSet<RadioStation>();
		parseData();
	}
	
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
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
