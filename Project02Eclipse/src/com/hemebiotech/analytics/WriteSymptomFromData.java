package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Map;

public class WriteSymptomFromData implements ISymptomWriter {

	/**
	 *
	 * Writing of symptoms in alphabetical order
	 * 
	 * @param mapSymptom : map of the symptoms in alphabetical order as well as
	 *                   their occurrences symptoms : list of symptoms
	 * @return result.out : display of occurrence symptom in alphabetical order
	 */

	public void writeResult(Map<String, Integer> mapSymptom) {
		FileWriter fw = null;
		BufferedWriter writer = null;

		try {

			File resultOut = new File("result.out");

			/* create the file if it doesn't exist */
			if (!resultOut.exists()) {
				resultOut.createNewFile();
			}

			fw = new FileWriter(resultOut.getAbsoluteFile());
			writer = new BufferedWriter(fw);

			/* Display header */
			writer.write("The symptoms present are : " + "\n");

			/* Display result */
			for (String key : mapSymptom.keySet()) {
				System.out.println(key + " = " + mapSymptom.get(key)); // Display in Console
				writer.write(key + " = " + mapSymptom.get(key) + "\n"); // Display in txtFile
			}

			/*
			 * Prints the stack trace of the System.err instance ( useful for diagnosing
			 * exceptions)
			 */
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			if (writer != null) {
				try {
					writer.close();

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}
	}
}
