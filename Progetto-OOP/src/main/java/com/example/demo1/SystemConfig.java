package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {
	@Bean
	public MetaData getMetaData() {
		return new MetaData();
	}

	@Bean
	public RadioSet getRadioSet() {
		return new RadioSet();
	}

	@Bean
	public RadioStation getRadio() {
		return new RadioStation();
	}

}
