package com.example.demo1;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SystemConfig {
	@Bean
	public RadioSet getRadioSet() throws IOException {
		return new RadioSet();
	}
	@Bean MetaSet getMetaSet() throws ClassNotFoundException, IOException {
		return new MetaSet();
	}
}
