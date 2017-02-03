import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.text.html.HTMLDocument.Iterator;

public class MainCollections {

	public static void main(String[] args) {

		List<ModelStudent> modelStudentList = new ArrayList<ModelStudent>();

		Map<String, ModelStudent> map = new HashMap<String, ModelStudent>();
		
		
		
		
		ModelStudent student = new ModelStudent();
		student.setName("Mahesh");
		student.setParentName("Suresh");
		modelStudentList.add(student);
		
		map.put("420", student);

		student = new ModelStudent();
		student.setName("Sachin");
		student.setParentName("Anand");
		modelStudentList.add(student);

		Comparator<ModelStudent> comparator = new Comparator<ModelStudent>() {

			@Override
			public int compare(ModelStudent std1, ModelStudent std2) {
				return std1.getParentName().compareTo(std2.getParentName());
			}
		};

//		Collections.sort(modelStudentList, comparator);
		for (int i = 0; i < modelStudentList.size(); i++) {
			System.out.println(" string at position  " + i + " "
					+" student name " +  modelStudentList.get(i).getName() 
					+ " parent name " + modelStudentList.get(i).getParentName());
		}

		// List<String> myList = new LinkedList();
		//
		// myList.add("First string");
		// myList.add("Second string");
		// myList.add("Third string");
		// myList.add("Fourth string");
		//
		// for (int i = 0; i < myList.size(); i++) {
		// System.out.println(" string at position  " + i + " " +
		// myList.get(i));
		// }
		//
		// System.out.println("============================");
		//
		// Map<String, String> myMap = new HashMap<String, String>();
		//
		// myMap.put("one", "One value");
		// myMap.put("two", "Two value");
		// myMap.put("three", "Three value");
		// myMap.put("four", "Four value");
		// myMap.put("five", "Five value");
		//
		// for (String key : myMap.keySet()) {
		// System.out.println(" string at key:  " + key + " " + myMap.get(key));
		// }

	}
}
