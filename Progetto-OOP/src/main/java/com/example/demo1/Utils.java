package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;

import java.nio.file.Paths;

import java.util.HashSet;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class Utils {

	public static final String COMMA_DELIMITER = ";";

	public static HashSet<RadioStation> parseCSV(HashSet<RadioStation> set) throws IOException {
		FileReader a = new FileReader("t1.csv");
		BufferedReader in = new BufferedReader(a);
		String line = "";
		String[] info;
		in.readLine(); // skippa la prima riga

		String operator = "n.d.";
		String ID = "n.d.";
		String type = "n.d.";
		String address = "n.d.";
		String lat = "n.d.";
		String lon = "n.d.";
		String alt = "n.d.";
		double channel = 0;
		String bouquet = "n.d.";
		double erpMaxH = 0;
		double erpMaxV = 0;
		double freq = 0;
		RadioStation r;

		while ((line = in.readLine()) != null) {

			info = line.split(COMMA_DELIMITER);
			try {

				operator = info[0];
				ID = info[1];
				type = info[2];
				address = info[3];
				lat = info[4];
				lon = info[5];
				alt = info[6];
				bouquet = info[8];
				try {
					channel = Double.parseDouble(commaConverter(info[7]));
				} catch (NumberFormatException e) {
					channel = 0;
				}
				try {
					erpMaxH = Double.parseDouble(commaConverter(info[9]));
				} catch (NumberFormatException e) {
					erpMaxH = 0;

				}
				try {
					erpMaxV = Double.parseDouble(commaConverter(info[10]));
				} catch (NumberFormatException e) {
					erpMaxV = 0;

				}
				try {
					freq = Double.parseDouble(commaConverter(info[11]));
				} catch (NumberFormatException e) {
					freq = 0;

				}
				try {
				} catch (NumberFormatException e) {
				} finally {
					r = new RadioStation(operator, ID, type, address, lat, lon, alt, channel, bouquet, erpMaxH, erpMaxV,
							freq);
					set.add(r);
				}
			} catch (IndexOutOfBoundsException e) {
				System.out.println("errore nel file, salto la riga");
			}

		}
		return set;
	}

	public static String commaConverter(String a) {
		char a1[] = a.toCharArray();
		String a2 = "";
		for (int i = 0; i < a1.length; i++) {
			if (a1[i] == ',') {
				a1[i] = '.';
				break;
			}
		}
		for (int i = 0; i < a1.length; i++) {
			a2 += a1[i];
		}
		return a2;
	}

	public static String getCSVUrl(String data) throws Exception {
		JSONObject obj = (JSONObject) JSONValue.parseWithException(data);
		JSONObject objI = (JSONObject) obj.get("result");
		JSONArray objA = (JSONArray) objI.get("resources");

		String format;
		String URL = "";
		for (Object o : objA) {
			if (o instanceof JSONObject) {
				JSONObject o1 = (JSONObject) o;
				format = (String) o1.get("format");
				if (format.toLowerCase().equals("csv"))
					URL = (String) o1.get("url");
				break;
			}
		}
		return URL;
	}

	public static void download(String url) throws Exception {
		int count = 0;
		try (InputStream in = URI.create(url).toURL().openStream()) {
			Files.copy(in, Paths.get("t1.csv"));
		} catch (FileAlreadyExistsException a) {
			System.out.println("il file c'è già");
		}
	}

	public static String jsonToString(String url) throws MalformedURLException, IOException {
		String data = "";
		String line = "";
		URLConnection openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");
		InputStream in = openConnection.getInputStream();
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader buf = new BufferedReader(inr);

		while ((line = buf.readLine()) != null) {
			data += line;

		}
		in.close();
		return data;
	}

	public static HashSet<MetaData> parseMetaData(HashSet<MetaData> set) throws ClassNotFoundException, IOException {
		Class cls = Class.forName("com.example.demo1.RadioStation");
		FileReader file = new FileReader("t1.csv");
		BufferedReader in = new BufferedReader(file);
		String line = "";
		line = in.readLine();
		String[] info = line.split(";");
		java.lang.reflect.Field[] fieldlist = cls.getDeclaredFields();
		MetaData metadata;
		for (int i = 0; i < info.length; i++) {
			Field fld = fieldlist[i];
			metadata = new MetaData();
			metadata.setAlias(fld.getName());
			metadata.setType(fld.getType().getSimpleName());
			metadata.setSourceField(info[i]);
			set.add(metadata);
		}
		return set;
	}
}
