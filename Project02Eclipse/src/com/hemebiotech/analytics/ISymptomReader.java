package com.hemebiotech.analytics;

import java.util.List;

/**
 * 
 * @author Flavien Hijazi created 27/07/23
 *
 *         Anything that will read symptoms data from a source.
 * 
 */
public interface ISymptomReader {

	List<String> GetSymptoms();
}
