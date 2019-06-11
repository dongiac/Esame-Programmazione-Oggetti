package com.example.demo;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MetaData {
	String alias;
	String sourcefield;
	String type;
	/**
	 * @param alias
	 * @param sourcefield
	 * @param type
	 */
	public MetaData(String alias, String sourcefield, String type) {
		this.alias = alias;
		this.sourcefield = sourcefield;
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "MetaData [alias=" + alias + ", sourcefield=" + sourcefield + ", type=" + type + "]";
	}

	/**
	 * 
	 */
	public MetaData() {
	}
	/**
	 * @return the alias
	 */
	public String getAlias() {
		return alias;
	}
	/**
	 * @return the sourcefield
	 */
	public String getSourcefield() {
		return sourcefield;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param alias the alias to set
	 */
	public void setAlias(String alias) {
		this.alias = alias;
	}
	/**
	 * @param sourcefield the sourcefield to set
	 */
	public void setSourcefield(String sourcefield) {
		this.sourcefield = sourcefield;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public static ArrayList<MetaData> getAllMetaData() throws ClassNotFoundException, IOException {
		Class cls = Class.forName("com.example.demo.RadioStation");
		FileReader file = new FileReader("t1.csv");
		BufferedReader in = new BufferedReader(file);
		String line = "";
		line = in.readLine();
		String[] info = line.split(";");
		Field fieldlist[] = cls.getDeclaredFields();
		MetaData metadata;
		ArrayList<MetaData> allMetadata = new ArrayList<MetaData>();
		for (int i = 0; i < info.length; i++) {
			Field fld = fieldlist[i];
			metadata = new MetaData();
			metadata.setAlias(fld.getName());
			metadata.setType(fld.getType().getSimpleName());
			metadata.setSourcefield(info[i]);
			allMetadata.add(metadata);
		}		
		return allMetadata;
	}
}
