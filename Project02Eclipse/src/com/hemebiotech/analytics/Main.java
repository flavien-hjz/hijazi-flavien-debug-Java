package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**
 * @author Flavien Hijazi created 31/07/23
 */

public class Main {

	public static void main(String[] args) {

		String filepath = "symptoms.txt";
		ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
		ISymptomWriter writer = new WriteSymptomDataToFile();
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		List<String> symptomsList = counter.getSymptoms();
		Map<String, Integer> symptomsMap = counter.countSymptoms(symptomsList);
		Map<String, Integer> symptomsSorted = counter.sortSymptoms(symptomsMap);
		counter.writeSymptoms(symptomsSorted);

	}

}
