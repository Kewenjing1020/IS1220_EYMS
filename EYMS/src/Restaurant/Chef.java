package Restaurant;

import java.io.Serializable;

import User.User;

/**
 * 
 * @author kewenjing
 *
 */
public class Chef extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 
	 * @param username
	 * @param password
	 */
	public Chef(String username, String password) {
		super(username, password);
	}



	/**
	 * 
	 */
	@Override
	public String toString() {
		return "Personnel [username=" + user_name + ", firstName=" + first_name + ", lastName=" + last_name + ", password="
				+ password + "]";
	}

}
