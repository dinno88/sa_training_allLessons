package edu.satraining.lesson11.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapController1 {
	public void mapOverview(){
		//Declaration
		Map<String, String> dayNameMap;
		
		// Initialization
		dayNameMap = new HashMap<String, String>();
		//Number of Element
		System.out.printf("Size of Map after initialization: %d%n", dayNameMap.size());
		//add element
		System.out.printf("%n");
		dayNameMap.put("Minggu", "Minggu");
		System.out.printf("Size of map after add 'Minggu' : %d%n", dayNameMap.size());

		System.out.printf("%n");
		dayNameMap.put("Senin", "Senin");
		System.out.printf("Size of map after add 'Senin' : %d%n", dayNameMap.size());

		System.out.printf("%n");
		dayNameMap.put("Selasa", "Selasa");
		System.out.printf("Size of map after add 'Selasa' : %d%n", dayNameMap.size());
		
		System.out.printf("%n");
		dayNameMap.put("Rabu", "Rabu");
		System.out.printf("Size of map after add 'Rabu' : %d%n", dayNameMap.size());
		
		System.out.printf("%n");
		dayNameMap.put("Kamis", "Kamis");
		System.out.printf("Size of map after add 'Kamis' : %d%n", dayNameMap.size());

		System.out.printf("%n");
		dayNameMap.put("Jumat", "Jumat");
		System.out.printf("Size of map after add 'Jumat' : %d%n", dayNameMap.size());

		System.out.printf("%n");
		dayNameMap.put("Sabtu", "Sabtu");
		System.out.printf("Size of map after add 'Sabtu' : %d%n", dayNameMap.size());

		//get specific element
		System.out.printf("%n");
		String mapValue = dayNameMap.get("Minggu");
		System.out.printf("Element of Map%n");
		System.out.printf("==============%n");
		showMapElement(dayNameMap);

		//remove element
		dayNameMap.remove("Senin");
		System.out.printf("Size of Map after remove 'Senin': %d%n%n", dayNameMap.size());
		System.out.printf("%n");
		System.out.printf("Element of map after 'Senin' remove%n");
		System.out.printf("===================================%n");
		showMapElement(dayNameMap);

		//modified element

		System.out.printf("%n");
		dayNameMap.put("Minggu", "Hari Minggu 1");
		System.out.printf("Size of map after put 'Minggu' : %d%n", dayNameMap.size());
		mapValue = dayNameMap.get("Minggu");
		System.out.printf("Element 'Minggu' after modified: %s%n", mapValue);
	}
	public void showMapElement(Map<String, String> dayNameMap){
	Set<String> keySet = dayNameMap.keySet();
	String mapValue = null;
	for(String mapKey : keySet){
	mapValue = dayNameMap.get(mapKey);
	System.out.printf("Element '%s': %s%n", mapKey, mapValue);
	}
	}
}