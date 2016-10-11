package com.statistics;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Compute {

	public static void main(String[] args) {
		Compute compute = new Compute();
		compute.execute();
	}

	public void execute() {
		Reader reader = new Reader();	
		List<String> list = reader.readFile("/sample.txt");		
		Map<Character, Integer> map1 = reader.getNumberOfTimesOccurrence(list);
		printResults(map1);
		System.out.println();
		Map<Character, Integer> map2 = reader.getNumberOfLinesOccurrence(list);
		printResults(map2);
	}
	
	private void printResults(Map<Character, Integer> map) {		
		Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> entry = iterator.next();
			System.out.printf("%c %d\n", entry.getKey(), entry.getValue());
		}
	}
	
}
