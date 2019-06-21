package com.example.demo1;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 
 * Configuration class that defines the beans instantiated by Spring framework
 *
 */
@Configuration
public class SystemConfig {
	/**
	 * Bean of RadioSet class instantiated by context.
	 * 
	 * @return The object of the RadioSet class.
	 * @throws IOException
	 */
	@Bean
	public RadioSet getRadioSet() throws IOException {
		return new RadioSet();
	}

	/**
	 * Bean of MetaSet class instantiated by context.
	 * 
	 * @return The object of the MetaSet class.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Bean
	public MetaSet getMetaSet() throws ClassNotFoundException, IOException {
		return new MetaSet();
	}

	/**
	 * Bean of ArrayList of MetaData class objects wired to MetaSet.
	 * 
	 * @return ArrayList of MetaData class objects.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */

	@Bean
	public ArrayList<MetaData> metaList() throws ClassNotFoundException, IOException {
		ArrayList<MetaData> set = new ArrayList<MetaData>();
		ParseUtils.parseMetaData(set);
		return set;
	}

	/**
	 * Bean of ArrayList of RadioStation class objects wired to RadioSet.
	 * 
	 * @return ArrayList of RadioStation class objects.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	@Bean
	public ArrayList<RadioStation> radioList() throws ClassNotFoundException, IOException {
		ArrayList<RadioStation> set = new ArrayList<RadioStation>();
		ParseUtils.parseCSV(set);
		return set;
	}

	/**
	 * Bean of FilterUtils wired to Utils.
	 * 
	 * @return FilterUtils class object to allow access to filter methods.
	 */
	@Bean
	public FilterUtils utilities() {
		return new FilterUtils();
	}

	/**
	 * Bean of MathUtils wired to Utils.
	 * @return MathUtils class object to allow access to math and word stats methods.
	 */

	@Bean
	public MathUtils mathutils() {
		return new MathUtils();
	}
	/**
	 * Bean of Utils that will contain all the utils.
	 * @return Utils class object.
	 */
	@Bean
	public Utils myUtils() {
		return new Utils();
	}
}
