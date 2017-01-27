package com.mathrusoft;

public class MyMainReverseNumber {

	public static void main(String[] args) {

		int number = 12389;
		int reverserdNumber = 0;
		while (number > 0) {
			reverserdNumber = (reverserdNumber * 10) + number % 10;
			number = number / 10;
		}
		
		System.out.println(" Reverse number " + reverserdNumber);

	}
}
