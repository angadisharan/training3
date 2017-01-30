package com.mathrusoft;

import com.mathrusoft.model.DemoAbsCat;

public class DemoAbstractMain {

	public static void main(String[] args) {

		DemoAbsCat absCat = new DemoAbsCat();

		System.out.println(" cat speak " + absCat.speak());
		 absCat.walk();
	}
}
