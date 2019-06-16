package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.stereotype.Component;

@Component
public class MetaSet extends Data <MetaData> {
	public MetaSet() {
		
	}
	
	@Override
	public void parseData() {
		try {
			Utils.parseMetaData((HashSet<MetaData>)this.set);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	