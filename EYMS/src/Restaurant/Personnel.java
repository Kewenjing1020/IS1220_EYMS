package Restaurant;

import java.io.Serializable;

/**
 * 
 * @author kewenjing
 *
 */
public class Personnel implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** 
	 * Attributes
	 */
	protected String username;
	protected String firstName;
	protected String lastName;
	protected String password;
	//protected Login login;
	
	
	/**
	 * @param username
	 * @param password
	 */
	public Personnel(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	/**
	 * Getters and Setters
	 */
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String first_name) {
		this.firstName = first_name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String last_name) {
		this.lastName = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Personnel [username=" + username + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + "]";
	}

}
