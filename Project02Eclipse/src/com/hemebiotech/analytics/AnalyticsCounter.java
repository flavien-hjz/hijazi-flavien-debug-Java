package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Flavien Hijazi created 28/07/23
 * 
 */

public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	/*
	 * @param reader the ISymptomReader interface
	 * 
	 * @param writer the ISymptomwriter interface
	 * 
	 * This method invokes the two interfaces.
	 */

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}

	/*
	 * @return the list of symptoms from a file
	 * 
	 * This method uses GetSymptoms method from ISymptomReader.
	 */

	public List<String> getSymptoms() {
		return reader.GetSymptoms();
	}

	/*
	 * @param symptoms the list of symptoms from GetSymptoms
	 * 
	 * @return symptomsMap the map of unique symptoms and their occurrences
	 * 
	 * For each key encountered for the first time in the list, this method puts 1
	 * as its value in the HashMap. If the key is not encountered for the first
	 * time, this method gets its value and adds 1 to it.
	 */

	public Map<String, Integer> countSymptoms(List<String> symptoms) {
		Map<String, Integer> symptomsMap = new HashMap<>();

		try {
			for (String i : symptoms) {
				if (symptomsMap.containsKey(i)) {
					symptomsMap.put(i, symptomsMap.get(i) + 1);
				} else {
					symptomsMap.put(i, 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		return symptomsMap;
	}

	/*
	 * @param symptoms the map from countSymptoms
	 * 
	 * @return symptoms the map sorted alphabetically
	 * 
	 * This method takes an HashMap and turns it into a TreeMap to sort the keys
	 * alphabetically.
	 */

	public Map<String, Integer> sortSymptoms(Map<String, Integer> symptoms) {
		return new TreeMap<>(symptoms);
	}

	/*
	 * @param symptoms the map from sortSymptoms
	 * 
	 * This method uses writeSymptoms method from ISymptomWriter.
	 */

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

}