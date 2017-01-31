package demo.exception;

public class MyException extends Exception {

	@Override
	public String getMessage() {
		return " MyExeption message abc---xyz " + super.getMessage();
	}
}
