package edu.satraining.lesson11.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapController2 {
	public void mapOverview(){
		//Declaration
		Map<String, String> dayNameMap;
		//initialization
		dayNameMap = new HashMap<String, String>();
		//Number of Element
		System.out.printf("Size of Map after Initialization: %d%n", dayNameMap.size());
		//Add Element
		System.out.printf("%n");
		dayNameMap.put("1", "Minggu");
		System.out.printf("Size of Map after add 'Minggu': %d%n", dayNameMap.size());

		dayNameMap.put("2", "Senin");
		System.out.printf("Size of Map after add 'Senin': %d%n", dayNameMap.size());

		dayNameMap.put("3", "Selasa");
		System.out.printf("Size of Map after add 'Selasa': %d%n", dayNameMap.size());

		dayNameMap.put("4", "Rabu");
		System.out.printf("Size of Map after add 'Rabu': %d%n", dayNameMap.size());

		dayNameMap.put("5", "Kamis");
		System.out.printf("Size of Map after add 'Kamis': %d%n", dayNameMap.size());

		dayNameMap.put("6", "Jumat");
		System.out.printf("Size of Map after add 'Jumat': %d%n", dayNameMap.size());

		dayNameMap.put("7", "Sabtu");
		System.out.printf("Size of Map after add 'Sabtu': %d%n", dayNameMap.size());

		//Get Specific Element
		System.out.printf("%n");
		String mapValue = dayNameMap.get("1");
		System.out.printf("Element '1': %d%n", mapValue);

		//Get All Element
		System.out.printf("%n");
		System.out.printf("Element of Map%n");
		System.out.printf("==============%n");
		showMapElement(dayNameMap);

		//Remove Element
		dayNameMap.remove("2");
		System.out.printf("%n");
		System.out.printf("Element of Map after '2' remove%n");
		System.out.printf("===============================%n");
		showMapElement(dayNameMap);

		//modified element
		System.out.printf("%n");
		dayNameMap.put("1", "Minggu 1");
		
	}
}