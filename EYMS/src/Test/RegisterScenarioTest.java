package Test;

import static org.junit.Assert.*;

import java.io.File;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import DataBase.DataClient;
import RestoChain.RestoChain;
import User.Client;

/**
 * Junit Test of the register scenario
 * @author Lucas
 *
 */

public class RegisterScenarioTest {

	Client marie = new Client("marie","12345","Marie","Vincent");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		//we first need to delete data of the clients already in the database
		ArrayList<Client> clients = new ArrayList<Client>();
		DataClient.Log_ClientData(clients);
	}

	@Test
	public void RegistrationTest() {
		RestoChain restoChain = new RestoChain();
		assertTrue("Marie is not yet registered", DataClient.verify(restoChain.getAllClients(),"marie"));
		marie.register();
		restoChain = new RestoChain();
		assertTrue("Marie is now registered", !DataClient.verify(restoChain.getAllClients(),"marie"));
	}

}
