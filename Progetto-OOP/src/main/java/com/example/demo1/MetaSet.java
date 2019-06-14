package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

public class MetaSet extends Data <MetaData> implements Parsable<MetaData> {
	public MetaSet(HashSet<MetaData> set) {
		super.set = set;
	}
	
	@Override
	public void dataParser(Collection<MetaData> col) {
		try {
			util.parseMetaData((HashSet<MetaData>)col);
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
