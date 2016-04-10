package Test;

import static org.junit.Assert.*; 

import org.junit.BeforeClass;
import org.junit.Test;

import User.Client;

public class LoginScenarioTest {

	static Client marie = new Client("marie","12345","Marie","Vincent");
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		marie.register();
	}

	@Test
	public void test() {
		marie.tryLogin();
	}

}
