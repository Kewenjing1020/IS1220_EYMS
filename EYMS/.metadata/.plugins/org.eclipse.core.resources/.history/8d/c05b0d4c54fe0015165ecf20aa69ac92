package DataBase;

import java.io.IOException;  
import User.*;

/**
 * to test Serializer
 * @author kewenjing
 *
 */
public class SerializerTest {

	public static void main(String[] args) {	
		
		Client client = new Client();
		client.setFirst_name("ke");
		client.setLast_name("wen");
		String username="cend";
		client.setUser_name(username);
		
		try {
	            /**
	             *  Serializing the object
	             */
	            Serializer.serialize(client, username+".txt");
	 
	            /**
	             * Deserializing the object
	             */
	            Client newClient = (Client) Serializer.deserialize("cend"+".txt");
	            
	            System.out.println(newClient);
	          
	 
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }


	}

}
