package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class RadioSet extends Data<RadioStation> implements Filter<RadioSet, Object> {

	public RadioSet() throws IOException {
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
			Utils.parseCSV((HashSet<RadioStation>) this.set);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
