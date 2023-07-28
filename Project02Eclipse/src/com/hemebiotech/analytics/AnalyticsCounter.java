package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
		
	public List<String> getSymptoms(){
		return reader.GetSymptoms();
	}
	
	public Map<String,Integer> countSymptoms(List<String> symptoms){
		Map<String,Integer> symptomsMap = new HashMap<>();
		
		try {
			for (String i : symptoms) {
				if (symptomsMap.containsKey(i)) {
					symptomsMap.put(i, symptomsMap.get(i)+1);
				} else {
					symptomsMap.put(i, 1);
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		return symptomsMap;	}
		
	public Map<String,Integer> sortSymptoms(Map<String,Integer> symptoms){
		return new TreeMap<>(symptoms);	
	}
		
	public void writeSymptoms(Map<String,Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}
		
}