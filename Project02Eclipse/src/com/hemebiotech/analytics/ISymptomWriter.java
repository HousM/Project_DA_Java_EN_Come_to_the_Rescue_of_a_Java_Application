package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

/**/
public interface ISymptomWriter {

	void writeResult(Map<String, Integer> mapSymptom, List<String> symptoms);

}
