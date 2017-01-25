package com.mathrusoft;

import com.mathrusoft.model.ModelPartTimeStudent;
import com.mathrusoft.model.ModelRegularStudent;
import com.mathrusoft.model.ModelStudent;

public class MyMain {

	public static void main(String[] args) {

		ModelRegularStudent student1 = new ModelRegularStudent();
		ModelPartTimeStudent student2 = new ModelPartTimeStudent();
		ModelPartTimeStudent student3 = new ModelPartTimeStudent();

		student1.setName("Mahesh");
		student1.setBranch("Mech");
		student1.setUSN("420");
		student1.setRegulatTimeTable("Its regular timetable");

		student2.setName("Ambi");
		student2.setBranch("MCA");
		student2.setUSN("123");
		student2.setParttimeTimeTable("Its parttime table");
		
		student3.setName("Jaggi");
		student3.setBranch("CSE");
		student3.setUSN("200");
		student3.setParttimeTimeTable("Its parttime table");

		System.out.println("Student 1 name = " + student1.getName());
		System.out.println("Student 1 Branch = " + student1.getBranch());
		System.out.println("Student 1 USN = " + student1.getUSN());
		System.out.println("Student 1 timetable = " + student1.getRegulatTimeTable());

		
		
		
	}

}
