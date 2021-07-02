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

/**********************************/
/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * @Param : File-path a full or partial path to file with symptom strings in it,
	 *        one per line
	 * @result : All not empty rows from a table read
	 * 
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.filepath = filepath;
	}

	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();
		BufferedReader reader = null;

		if (filepath != null) {
			try {
				reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();

			} catch (Exception e) {
				e.printStackTrace();

			} finally {

				if (reader != null) {
					try {

						reader.close();

					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}
		}

		return result;
	}
}
