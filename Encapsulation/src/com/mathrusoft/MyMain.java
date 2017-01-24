package com.mathrusoft;

import com.mathrusoft.model.ModelStudent;

public class MyMain {

	public static void main(String[] args) {

		ModelStudent student1 = new ModelStudent();
		ModelStudent student2 = new ModelStudent();
		ModelStudent student3 = new ModelStudent();

		student1.setName("Mahesh");
		student1.setBranch("Mech");
		student1.setUSN("420");

		student2.setName("Ambi");
		student2.setBranch("MCA");
		student2.setUSN("123");

		student3.setName("Jaggi");
		student3.setBranch("CSE");
		student3.setUSN("200");

		System.out.println("Student 1 name = " + student1.getName());
		System.out.println("Student 1 Branch = " + student1.getBranch());
		System.out.println("Student 1 USN = " + student1.getUSN());

	}

}
