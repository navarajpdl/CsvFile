package com.navaraj.utility;

import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.opencsv.CSVReader;

public class CsvReader {

	private static final String FILE_PATH = "/Users/navaraj/Desktop/Project/test.csv";

	// read the data from file
	// return list
	
	public List<String[]> getAllDataASStringArray() {

		List<String[]> allData = new ArrayList<String[]>();

		try {
			Reader reader = Files.newBufferedReader(Paths.get(FILE_PATH));
			CSVReader csvReader = new CSVReader(reader);
			
			

			allData = csvReader.readAll();

		} catch (Exception e) {
			System.out.println("data not found");
		}

		return allData;
	}
}
