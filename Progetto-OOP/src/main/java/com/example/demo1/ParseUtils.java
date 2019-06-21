package com.example.demo1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
/**
 * This class contains all the methods for downloading the csv, converting JSONObjects, the parsing of data from the csv file to the RadioStation class and more.
 * 
 */
public class ParseUtils {
    /**
    * Separator character of the csv file.
    */
	public static final String COMMA_DELIMITER = ";";
	/**
	 * Parses the csv named "t1.csv" into a RadioStation Class object which is added to the Collection set.
	 * @param set Collection of RadioStation objects used to contain the parsed data.
	 */
	public static void parseCSV(ArrayList<RadioStation> set) {
		try {
		FileReader a = new FileReader("t1.csv");
		BufferedReader in = new BufferedReader(a);
		String line = "";
		String[] info;
		in.readLine(); // skippa la prima riga

		RadioStation r;

		while ((line = in.readLine()) != null) {

			info = line.split(COMMA_DELIMITER);
			try {

				r = new RadioStation(info[0], info[1], info[2], info[3], info[4], info[5], info[6], ParseUtils.commaConverter(info[7]), info[8],
						ParseUtils.commaConverter(info[9]), ParseUtils.commaConverter(info[10]),
						ParseUtils.commaConverter(info[11]));
				set.add(r);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Errore nel file, controllare eventualmente che il separatore sia il carattere ';' o che il file non sia danneggiato");
				System.out.println("Riga saltata: " + info);
			}

		}
		in.close();
		} catch(IOException e) {
			System.out.println("Errore generico avvenuto durante il parsing");
		}
	}
	/**
	 * Sometimes a ',' char is used to define decimal numbers: this char is not supported from java so it's necessary to convert this char to '.' char.
	 * @param a The string containing the number we want to analyze.
	 * @return A correct double number supported by java.
	 */
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
	/**
	 * Search and eventually gets the download url of the csv file from a JSONObject converted to String and passed as parameter.
	 * @param data The data we want to analyze.
	 * @return The download csv url.
	 */
	public static String getCSVUrl(String data) {
		JSONObject obj;
		try {
			obj = (JSONObject) JSONValue.parseWithException(data);
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
		} catch (NullPointerException e) {
			System.out.println("Uno dei campi result/resources fornito dal link non contiene le informazioni necessarie per completare l'operazione, il programma verrà terminato.");
		} catch (ParseException e) {
			System.out.println("Errore durante il parsing dei dati");
		}

		return null;

	}
	/**
	 * Downloads a file given the url.
	 * @param url Url.
	 */
	public static void download(String url) {
		
		try (InputStream in = URI.create(url).toURL().openStream()) {
			System.out.println("Salvo con nome 't1.csv'");
			Files.copy(in, Paths.get("t1.csv"), StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException e) {
			System.out.println("Il file con il nome t1.csv esiste già ed è stato sovrascritto");
		} catch (IOException e) {
			System.out.println("Errore durante il download del file");
		}
	}
	/**
	 * Converts JSONObject to String.
	 * @param url
	 * @return
	 */
	public static String jsonToString(String url) {
		
		
		String data = "";
		
		String line = "";
		URLConnection openConnection;
		InputStream in;
		try {
		openConnection = new URL(url).openConnection();
		openConnection.addRequestProperty("User-Agent",
				"Mozilla/5.0 (Windows NT 6.1; WOW64; rv:25.0) Gecko/20100101 Firefox/25.0");

	
		
		in = openConnection.getInputStream();
		InputStreamReader inr = new InputStreamReader(in);
		BufferedReader buf = new BufferedReader(inr);

		
			while ((line = buf.readLine()) != null) {
				data += line;
			}
		}
			catch (IOException e) {
				System.out.println("L'url potrebbe non essere valido o potrebbe essere stata interrotta l'operazione di I/O");
			}
	
			finally {
				return data;
			}
		
		
	}
	/**
	 * Gets and parses the MetaData for the RadioStation class into a ArrayList of MetaData objects.
	 * @param set Collection that will contain the MetaData.
	 * @return The ArrayList containing MetaData.
	 * @throws ClassNotFoundException
	 * @throws IOException
	 */
	public static ArrayList<MetaData> parseMetaData(ArrayList<MetaData> set)
			throws ClassNotFoundException, IOException {
		Class cls = Class.forName("com.example.demo1.RadioStation"); 
		FileReader file = new FileReader("t1.csv");
		BufferedReader in = new BufferedReader(file);
		String line = "";
		line = in.readLine();
		String[] info = line.split(";");
		Field[] fieldlist = cls.getDeclaredFields();
		MetaData metadata;
		for (int i = 0; i < info.length; i++) {
			Field fld = fieldlist[i];
			metadata = new MetaData();
			metadata.setAlias(fld.getName());
			metadata.setType(fld.getType().getSimpleName());
			metadata.setSourceField(info[i]);
			set.add(metadata);
		}
		in.close();
		return set;
	}
}
