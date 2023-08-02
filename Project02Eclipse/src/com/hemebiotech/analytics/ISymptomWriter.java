package com.hemebiotech.analytics;

import java.util.Map;

/**
 * 
 * @author Flavien Hijazi
 * created 27/07/23
 *
 * Anything that will write symptoms and their occurrences.
 */

public interface ISymptomWriter {

	public void writeSymptoms(Map<String, Integer> symptoms);

}
