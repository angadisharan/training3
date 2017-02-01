import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;


public class ClassDemoSortList {

	public static void main(String[] args) {
		
		List<String> myList = new LinkedList(); 

		myList.add("Sachin");
		myList.add("Rahul");
		myList.add("Sindhu");
		myList.add("Sania");
		myList.add("Anand");
		
		Comparator<String> comparator = new Comparator<String>() {
			@Override
			public int compare(String lhs, String rhs) {
				return rhs.compareTo(lhs);
			}
		};
		
		
		Collections.sort(myList, comparator);
		
		for (int i = 0; i < myList.size(); i++) {
			System.out.println(" " + myList.get(i));
		}
		
		

	}
	
	
}
