package com.statistics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Reader {

	public List<String> readFile (String fileName) {
		List<String> list = new LinkedList<>();
		try (BufferedReader bufferReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream(fileName))) ) {
			String line = null;
			while ((line = bufferReader.readLine()) != null) {
				list.add(line);
			}
		} catch (IOException exception) {
			System.out.println("Cannot read file!");
		}
		return list;
	}
	
	private Map<Character, Integer> getCharactersCount (String text) {
		Map<Character, Integer> map = new HashMap<>();
		for (int index = 0; index < text.length(); index++) {
			char character = text.charAt(index);
			increaseMap(map, character, 1);
		}
		return map;
	}

	private Set<Character> getCharacters (String text) {
		Set<Character> set = new HashSet<>();
		for (int index = 0; index < text.length(); index++) {
			char character = text.charAt(index);
			set.add(character);
		}
		return set;
	}
	
	
	public Map<Character, Integer> getNumberOfTimesOccurrence(List<String> lines) {
		Map<Character, Integer> mapTotal = new HashMap<>();
		for(String line : lines) {
			Map<Character, Integer> map = getCharactersCount(line);
			Iterator<Entry<Character, Integer>> iterator = map.entrySet().iterator();
			while(iterator.hasNext()) {
				Entry<Character, Integer> entry = iterator.next();
				increaseMap(mapTotal, entry.getKey(), entry.getValue());
			}
		}
		return mapTotal;
	}

	public Map<Character, Integer> getNumberOfLinesOccurrence(List<String> lines) {
		Map<Character, Integer> mapTotal = new HashMap<>();
		for(String line : lines) {
			Set<Character> set = getCharacters(line);
			Iterator<Character> iterator = set.iterator();
			while(iterator.hasNext()) {
				Character character = iterator.next();
				increaseMap(mapTotal, character, 1);
			}
		}
		return mapTotal;
	}
	
	
	private <T> void increaseMap(Map<T, Integer> map, T value, int increment) {
		if (map.get(value) == null) {
			map.put(value, increment);
		} else {
			map.put(value, map.get(value) + increment);
		}
	}
	
}
