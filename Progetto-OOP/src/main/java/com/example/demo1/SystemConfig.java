package com.example.demo1;
import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {
	@Bean
	public RadioSet getRadioSet() throws IOException {
		return new RadioSet();
	}

	@Bean
	public MetaSet getMetaSet() throws ClassNotFoundException, IOException {
		return new MetaSet();
	}

	
	@Bean
	public ArrayList<MetaData> metaList() throws ClassNotFoundException, IOException {
		ArrayList<MetaData> set = new ArrayList<MetaData>();
		ParseUtils.parseMetaData(set, args[1]);
		return set;
	}
	
	
	@Bean
	public ArrayList<RadioStation> radioList() throws ClassNotFoundException, IOException {
		ArrayList<RadioStation> set = new ArrayList<RadioStation>();
		ParseUtils.parseCSV(set, args[1]);
		return set;
	}
	
	@Bean
	public FilterUtils utilities() {
		return new FilterUtils();
	}
	
	@Bean
	public MathUtils mathutils() {
		return new MathUtils();
	}
	
	@Bean
	public Utils myUtils() {
		return new Utils();
	}
}
