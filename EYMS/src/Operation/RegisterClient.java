package Operation;

import java.io.Serializable;
import java.util.ArrayList;

import DataBase.DataClient;
import User.Client;

public class RegisterClient implements Register, Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 148191707856369546L;

	@Override
	public void register(String first_name, String last_name, String user_name, String password) {
		ArrayList<Client> clients = new ArrayList<Client>();
		clients.add(new Client(user_name,password,first_name,last_name));
		DataClient.Log_ClientData(clients);

	}

}
