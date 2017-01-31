package demo.exception;

public class DemoException {

	public static void main(String[] args) {

		try {
			float x = 5 / 2;
			System.out.println(" x = " + x);
		} catch (Exception e) {
			System.out.println("Error Message " + e.getMessage());
			e.printStackTrace();
		}
		
		//==================================

		int[] tempArray = {1, 2, 4, 5};
		
		try {
			System.out.println(" tempArray [5] " + tempArray[5]);
		} catch (Exception e) {
			System.out.println("Error Message " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("Programming running after expresstion=====");

		
		//==================================
		
		try {
			throwMyException();
		} catch (MyException e) {
			System.out.println("Error Message " + e.getMessage());
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

	public static void throwMyException() throws MyException {
		
		throw new MyException();
	}
	
	
}
