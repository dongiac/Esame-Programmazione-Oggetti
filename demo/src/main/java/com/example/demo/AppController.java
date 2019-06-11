package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
	@RequestMapping("/data")
	@ResponseBody
	public HashSet<RadioStation> getData() throws IOException {
		HashSet<RadioStation> set = new HashSet<RadioStation>();
		CSV.parseCSV(set);
		return set;
	}
	@RequestMapping("/Metadata")
	@ResponseBody
	public ArrayList<MetaData> getMetaData() throws ClassNotFoundException, IOException{
		ArrayList<MetaData> m = new ArrayList<MetaData>();
		m = MetaData.getAllMetaData();
		return m;
	}
	
}
