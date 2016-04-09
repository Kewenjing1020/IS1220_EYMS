package User;

import java.io.Serializable;

import Operation.Login;
import Operation.Register;

/**
 * Abstract class for User of Restaurant: Client and Personnel
 * It allows to extend the project in a more flexible way using inheritance.
 * 
 * @author Lucas
 *
 */

public abstract class User implements Serializable{

	private static final long serialVersionUID = 1329037479554738244L;
	
	/** 
	 * Attributes
	 */
	
	protected String user_name = " ";
	protected String first_name = " ";
	protected String last_name = " ";
	protected String password = " ";
	//each user can have a specific method to connect
	protected Login login;
	//each user have a specific method to register
	protected Register register;
	
	
	/**
	 * Method which allows an user to login
	 */
	public void tryLogin(){
		login.login(this);
	}
	
	/**
	 * Method which allows an user to register and add him to the DataBase
	 */
	public void register(){
		register.register(this.getFirstName(), this.getLastName(), 
						  this.getUsername(), this.getPassword());
	}
	
	
	/**
	 * @param username
	 * @param password
	 */
	
	public User(){
		
	}
	
	public User(String username, String password) {
		super();
		this.user_name = username;
		this.password = password;
	}

	
	/**
	 * Getters and Setters
	 */
	
	public String getUsername() {
		return user_name;
	}

	public void setUsername(String username) {
		this.user_name = username;
	}
	public String getFirstName() {
		return first_name;
	}
	public void setFirstName(String first_name) {
		this.first_name = first_name;
	}
	public String getLastName() {
		return last_name;
	}
	public void setLastName(String last_name) {
		this.last_name = last_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
	

