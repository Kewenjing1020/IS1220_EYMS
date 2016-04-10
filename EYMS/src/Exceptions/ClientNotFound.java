package Exceptions;

/**
 * Exception raised when a Login fails
 * 
 * @author Lucas
 *
 */
public class ClientNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7988194009056328850L;

	public ClientNotFound(String username, String password){
		System.err.println("No Client found corresponding to the username: " + username 
				+ " and the password: " + password + ".\n"
				+ " Please try again or register");
	}
}
