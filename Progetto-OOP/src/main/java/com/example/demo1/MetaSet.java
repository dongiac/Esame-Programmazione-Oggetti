package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;


public class MetaSet extends Data <MetaData> {
	public MetaSet() throws ClassNotFoundException, IOException {
		System.out.println("Ho creato ottenuto i metadati...");
		super.set = new HashSet<MetaData>();
		parseData();
	}
	
	@Override
	public void parseData() {
		try {
			Utils.parseMetaData((HashSet<MetaData>)super.set);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
	