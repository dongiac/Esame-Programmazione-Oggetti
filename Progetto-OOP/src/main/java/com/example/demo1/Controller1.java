package com.example.demo1;

import java.io.IOException;
import java.util.HashSet;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class Controller1 extends ProgettoOopApplication {

	@RequestMapping("/data")
	@ResponseBody
	public HashSet<RadioStation> getRadioSet() throws IOException {
		/*
		 * HashSet<RadioStation> set = new HashSet<RadioStation>(); //il massimo che si
		 * può fare sembra sia creare un contesto col quale invocare radioset (parsando
		 * nel costruttore i dati...) RadioSet Rset = new RadioSet();
		 * Rset.parseData(set); return (HashSet<RadioStation>)Rset.getData();
		 */
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		RadioSet a = ctx.getBean(RadioSet.class);
		a.parseData();                                    //non riesco a fare il parsing dei dati prima della chiamata get, non risulta visibile e un calcolo del genere 
															//in grandi dimensioni potrebbe essere un problema.
		return (HashSet<RadioStation>) a.getData();
	}

	@RequestMapping("/metadata")
	@ResponseBody
	public HashSet<MetaData> getMetaSet() throws IOException, ClassNotFoundException {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(SystemConfig.class);
		MetaSet ms = ctx.getBean(MetaSet.class);
		ms.parseData();
		return (HashSet<MetaData>) ms.getData();
	}
}

/*
 * metodo di riserva, degli inizi prima del futuro disastro.
 * 
 * @RequestMapping("/metadata")
 * 
 * @ResponseBody public HashSet<MetaData> getMetaSet() throws IOException,
 * ClassNotFoundException { HashSet<MetaData> set = new HashSet<MetaData>();
 * MetaSet ms = new MetaSet(set); ms.parseData(set); return
 * (HashSet<MetaData>)ms.getData(); }
 */