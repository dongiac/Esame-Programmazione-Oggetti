package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.springframework.stereotype.Component;


public class MetaSet extends Data <MetaData> {
	public MetaSet(HashSet<MetaData> set) {
		super.set = set;
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
