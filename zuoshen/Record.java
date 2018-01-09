package com.alogrithm.review;

import java.util.HashMap;
import java.util.Map.Entry;

public class Record {

	private HashMap<String, HashMap<String, Integer>> record;

	public Record(String[] strArr) {

		record = new HashMap<String, HashMap<String, Integer>>();
		HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
		for (int i = 0; i < strArr.length; i++) {
			String curStr = strArr[i];
			update(indexMap, curStr, i);
			indexMap.put(curStr, i);
		}

	}

	private void update(HashMap<String, Integer> indexMap, String str, int i) {

		if (!record.containsKey(str)) {
			record.put(str, new HashMap<String, Integer>());
		}

		HashMap<String, Integer> strMap = record.get(str);

		for (Entry<String, Integer> lastEntry : indexMap.entrySet()) {
			String key = lastEntry.getKey();
			Integer index = lastEntry.getValue();
			if (!key.equals(str)) {
				HashMap<String, Integer> lastMap = record.get(key);
				int curMin = i - index;
				if (strMap.containsKey(key)) {
					int preMin = strMap.get(key);
					if (curMin < preMin) {
						strMap.put(key, curMin);
						lastMap.put(str, curMin);
					}
				}else{
					strMap.put(key, curMin);
					lastMap.put(str, curMin);
				}

			}

		}

	}

}
