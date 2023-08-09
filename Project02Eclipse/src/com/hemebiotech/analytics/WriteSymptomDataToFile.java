package com.hemebiotech.analytics;

import java.io.FileWriter;

import java.io.IOException;
import java.util.Map;

/**
 * @author Flavien Hijazi created 27/07/23
 */

public class WriteSymptomDataToFile implements ISymptomWriter {

	/**
	 * @param symptoms the HashMap used to write symptoms and their occurrences in a
	 *                 new file result.out
	 * 
	 *                 This method writes in a file named result.out the symptoms
	 *                 from the HashMap, followed by their occurrences.
	 */

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {

		try (FileWriter writer = new FileWriter("result.out")) {
			for (String symptom : symptoms.keySet()) {
				writer.write(symptom + " : " + symptoms.get(symptom) + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
