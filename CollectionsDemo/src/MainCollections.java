import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;


public class MainCollections {

	public static void main(String[] args) {
		
		
		List<String> myList = new LinkedList(); 

		myList.add("First string");
		myList.add("Second string");
		myList.add("Third string");
		myList.add("Fourth string");

		for (int i = 0; i < myList.size(); i++) {
			System.out.println(" string at position  " + i + " " + myList.get(i));	
		}
		
		System.out.println("============================");
		
		Map<String, String> myMap = new HashMap<String, String>(); 

		myMap.put("one", "One value");
		myMap.put("two", "Two value");
		myMap.put("three", "Three value");
		myMap.put("four", "Four value");
		myMap.put("five", "Five value");
		
		for (String key : myMap.keySet()) {
			System.out.println(" string at key:  " + key + " " + myMap.get(key));	
		}		
		
	}

}
