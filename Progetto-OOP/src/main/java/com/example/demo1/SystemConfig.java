package com.example.demo1;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

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
	public Collection<RadioStation> radioList() throws IOException {
		HashSet<RadioStation> set = new HashSet<RadioStation>();
		Utils.parseCSV(set);
		return set;
	}

	@Bean
	public Collection<MetaData> metaList() throws ClassNotFoundException, IOException {
		HashSet<MetaData> set = new HashSet<MetaData>();
		Utils.parseMetaData(set);
		return set;
	}

	@Bean
	public FilterUtils<RadioStation> utilities() {
		return new FilterUtils<RadioStation>();
	}
}
