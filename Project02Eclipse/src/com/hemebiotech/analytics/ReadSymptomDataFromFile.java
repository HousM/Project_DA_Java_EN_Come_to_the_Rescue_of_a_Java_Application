package com.hemebiotech.analytics;

/*** Import input/output classes...
 .. *********/
import java.io.BufferedReader;
import java.io.FileReader;
/**********************************/
/*** Import utility classes...
.. *********/
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**********************************/
/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @Param : File-path a full or partial path to file with symptom strings in it,
	 *        one per line
	 * @result : All not empty rows from a table read
	 * 
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public List<String> GetSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		while (true) {
			if (filepath != null) {
				try {
					BufferedReader reader = new BufferedReader(new FileReader(filepath));
					String line = reader.readLine();

					while (line != null) {
						result.add(line);
						line = reader.readLine();
					}
					reader.close();
					break;
				} catch (Exception e) {
					System.out.println("Reading error. Start again ? ");
					Scanner scan = new Scanner(System.in);
					String response = scan.nextLine().trim();
					if (response.equalsIgnoreCase("no")) {
						break;
					}
					scan.close();
				}
			}
		}

		return result;
	}

}
