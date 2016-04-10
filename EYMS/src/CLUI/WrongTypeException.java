package CLUI;

public class WrongTypeException extends Exception {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WrongTypeException(){
		System.out.println("Invalid input, please retype");
	}
}
