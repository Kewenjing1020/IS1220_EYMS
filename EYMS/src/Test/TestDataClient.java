package Test;

import java.util.ArrayList;


import DataBase.DataClient;
import Exceptions.ClientNotFound;
import User.Client;

/**
 * Test for DataClient: test on method using the database of the clients
 * @author Lucas
 *
 */
public class TestDataClient {

	public static void main(String [] args) throws ClientNotFound{
		ArrayList<Client> clients=new ArrayList<Client>();
		clients.add(new Client("emma","12345","Emma","Watson"));
		clients.add(new Client("lily","34567"));
		DataClient.Log_ClientData(clients);
		//Client emma = new Client("emma","12345");
		//Client lily = new Client("lily","34567");
		//emma.register();
		//lily.register();
		ArrayList<Client> clients2=new ArrayList<Client>();
		clients2=DataClient.Load_ClientData();
		Client emma=clients2.get(0);
		System.out.println(emma.getPassword());
		System.out.println(emma);
		emma.add_phone_number("680962887");
		//System.out.println(emma);
		clients=DataClient.refresh_clientdata(emma, clients);
		System.out.println(clients);
		
		emma.tryLogin();
		Client adrien = new Client("adrien","04538","Adrien","Michel");
		clients.add(adrien);
		System.out.println(adrien);
		adrien.register();
		adrien.tryLogin();
		adrien.add_address("centrale paris");
		DataClient.Log_ClientData(clients);
	}
}
