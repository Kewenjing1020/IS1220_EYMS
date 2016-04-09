package Operation;

import java.io.Serializable;

import DataBase.DataClient;
import User.User;

/**
 * Login Method for client which allows them to login
 * @author Lucas
 *
 */

public class LoginClient implements Login, Serializable{

	private static final long serialVersionUID = -5414979873497916656L;

	@Override
	public void login(User user) {
		System.out.println("Hi I want to connect");
		System.out.println("Please enter your username and your password:");
		System.out.println("username: " + user.getUsername());
		System.out.println("password: " + user.getPassword());
		DataClient.login(user.getUsername(), user.getPassword());
		
	}


		
}

	

