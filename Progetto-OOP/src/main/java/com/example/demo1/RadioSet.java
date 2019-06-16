package com.example.demo1;

import java.io.IOException;

import org.springframework.stereotype.Component;

@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioSet, Object> {
	
	public RadioSet() throws IOException {
	}
	
	
	@Override
	public String toString() {
		return "RadioSet [set=" + set + "]";
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
