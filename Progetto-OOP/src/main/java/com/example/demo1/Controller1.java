package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Controller1 {
	@RequestMapping("/data")
	@ResponseBody
	public HashSet<RadioStation> getRadioSet() throws IOException {
		HashSet<RadioStation> set = new HashSet<RadioStation>();
		RadioSet Rset = new RadioSet(set);
		Rset.dataParser(set);
		return (HashSet<RadioStation>)Rset.getData();
	}
	
	@RequestMapping("/metadata")
	@ResponseBody
	public HashSet<MetaData> getMetaSet() throws IOException, ClassNotFoundException {
		HashSet<MetaData> set = new HashSet<MetaData>();
		MetaSet ms = new MetaSet(set);
		Utils.parseMetaData(set);
		return (HashSet<MetaData>)ms.getData();
	}
}
