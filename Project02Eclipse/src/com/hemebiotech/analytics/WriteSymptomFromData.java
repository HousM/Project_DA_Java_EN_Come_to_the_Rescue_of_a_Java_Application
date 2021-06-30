package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WriteSymptomFromData implements ISymptomWriter {

	/**
	 *
	 * Writing of symptoms in alphabetical order
	 * 
	 * @param mapSymptom : map of the symptoms in alphabetical order as well as
	 *                   their occurrences symptoms : list of symptoms
	 * @return result.out : display of occurrence symptom in alphabetical order
	 */

	public void writeResult(Map<String, Integer> mapSymptom, List<String> symptoms) {
		while (true) {
			try {

				File resultOut = new File("result.txt");

				/* create the file if it doesn't exist */
				if (!resultOut.exists()) {
					resultOut.createNewFile();
				}

				FileWriter fw = new FileWriter(resultOut.getAbsoluteFile());
				BufferedWriter writer = new BufferedWriter(fw);

				/* Display header */
				writer.write(" The symptoms present are " + "\n");

				/* Display result */
				for (String key : mapSymptom.keySet()) {
					System.out.println(key + " = " + mapSymptom.get(key)); // Display in Console
					writer.write(key + " = " + mapSymptom.get(key) + "\n"); // Display in txtFile
				}
				writer.close();
				break;

				/*
				 * Prints the stack trace of the System.err instance ( useful for diagnosing
				 * exceptions)
				 */
			} catch (Exception e) {

				System.out.println("Writing error. Start again ? ");
				Scanner scan = new Scanner(System.in);
				String response = scan.nextLine().trim();
				if (response.equalsIgnoreCase("no")) {
					break;
				}
				scan.close();

			}

		}

	}
}
