package com.hemebiotech.analytics;

import java.util.ArrayList;
import java.util.List; // import of the LIST utility class to use
import java.util.Map; // import of the Map utility class to use
import java.util.TreeMap; // import of the mapTree utility class to use

/**
 * 
 * Takes a list of symptoms and return map of symptoms with occurrence and
 * sorted by alphabetical order
 * 
 * @Param : List of symptoms
 * @result : Map of occurrences symptoms sorted
 * 
 * @author HousM
 *
 */

public class AnalyticsCounter {

	private String inputDoc; // File of symptoms to analyze
	private List<String> listSymptoms = new ArrayList<String>();// List of symptoms
	private Map<String, Integer> mapCount = new TreeMap<String, Integer>();// Symptom map sorted in alphabetical order

	// Launching program
	public void launch_pg(String inputDoc) {
		this.inputDoc = inputDoc;
		this.getSymptoms();
		this.mapCountTree();
		this.writeResult();
	}

	// Read List of Symptoms
	private void getSymptoms() {
		ReadSymptomDataFromFile ReadSymptomDataFromFile = new ReadSymptomDataFromFile(inputDoc);
		listSymptoms = ReadSymptomDataFromFile.getSymptoms();
	}

	// Count and tree occurrence
	// test
	private Map<String, Integer> mapCountTree() {

		for (String symptom : listSymptoms) {
			if (mapCount.containsKey(symptom)) {
				mapCount.put(symptom, (mapCount.get(symptom) + 1));
			} else {
				mapCount.put(symptom, 1);
			}
		}
		for (String key : mapCount.keySet()) {

			System.out.println(key + " = " + mapCount.get(key));
		}
		return mapCount;
	}

	// Writing and displaying result of analyze...
	private void writeResult() {
		WriteSymptomFromData writerSymptom = new WriteSymptomFromData();
		writerSymptom.writeResult(mapCount);
	}

}
