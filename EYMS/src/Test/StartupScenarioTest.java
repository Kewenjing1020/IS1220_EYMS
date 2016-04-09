package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import DataBase.DataClient;
import DataBase.DataResto;
import Restaurant.Meal;
import Restaurant.Restaurant;
import RestoChain.RestoChain;
import User.Client;

/**
 * JUnit Test for the start up scenario
 * @author Lucas
 *
 */

public class StartupScenarioTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		ArrayList<Restaurant> restaurants=new ArrayList<Restaurant>();
		Restaurant resto=new Restaurant("CentraleResto");
		Meal e = new Meal("salad",(double)5,(double)3.5);
		//this meal has a special price and will generate special offers send to the client registered
		resto.createMeal(e);
		restaurants.add(resto);
		DataResto.Log_RestoData(restaurants);
		
		ArrayList<Client> clients=new ArrayList<Client>();
		clients.add(new Client("emma","12345"));
		//emma will be notified for special price offer only
		Client alexia = new Client("alexia","1649832","10/04/2016");
		//alexia will be notified also for her birthday at the initialisation of the system
		clients.add(alexia);
		DataClient.Log_ClientData(clients);
	}


	@Test
	public void StartupTest() {
		RestoChain restoChain = new RestoChain("10/04/2016");
		ArrayList<Client> clients=new ArrayList<Client>();
		clients = DataClient.Load_ClientData(); 
		Client emma = new Client();
		Client alexia = new Client();
		emma = restoChain.getAllClients().get(0);
		alexia = restoChain.getAllClients().get(1);
		assertTrue("special price only", emma.getEmail().size()==1);
		assertTrue("special price and birthday offer", alexia.getEmail().size()==2);
	}
}
