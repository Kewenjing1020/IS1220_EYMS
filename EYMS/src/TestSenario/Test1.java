package TestSenario;

import java.io.IOException;
import java.util.ArrayList;

import DataBase.DataClient;
import FidelityCard.BasicFidelityCard;
import FidelityCard.PointFidelityCard;
import Restaurant.Meal;
import User.Client;

/**
 * create a database of client and restaurant
 * @author kewenjing
 *
 */

public class Test1 {
	
	
	/**
	 * return "Client [authorization=" + authorization + ", birthday=" + birthday + ", fidelityCard=" + fidelityCard
				+ ", contacter_names=" + contacter_names + ", email=" + email + ", phone_number=" + phone_number
				+ ", address=" + address + ", favorite_meals=" + favorite_meals + "]";
	 */
	
	public static void main(String [] args) {
		
		ArrayList<Client> clients=new ArrayList<Client>();
		DataClient.Log_ClientData(clients);
		Client c1=new Client("user_name1", "password1", "first_name1", "last_name1",true, "06/01",new BasicFidelityCard());
		Client c2=new Client("user_name2", "password2", "first_name2", "last_name2",true, "07/02",new BasicFidelityCard());
		Client c3=new Client("user_name3", "password3", "first_name3", "last_name3",false, "07/03",new BasicFidelityCard());
		Client c4=new Client("user_name4", "password4", "first_name4", "last_name4",false, "08/04",new PointFidelityCard());
		c1.add_address("address1");
		c1.add_address("address2");
		c1.add_email("new_email1");
		c1.add_email("new_email2");
		c1.add_phone_number("new_phone_number1");
		c1.add_phone_number("new_phone_number2");
		c1.add_contactInfo("contactname1", "phonenumber3", "adress3");
		System.out.println(c1);
		
		c2.add_address("address1");
		c2.add_address("address2");
		c2.add_email("new_email1");
		c2.add_email("new_email2");
		c2.add_phone_number("new_phone_number1");
		c2.add_phone_number("new_phone_number2");
		c2.add_contactInfo("contactname1", "phonenumber3", "adress3");
		c2.associateCard(new PointFidelityCard());
		System.out.println(c2);
		clients.add(c1);
		clients.add(c2);
		clients.add(c3);
		clients.add(c4);
		
		DataClient.Log_ClientData(clients);
		
		
		Meal e1=new Meal();
		
		
	
	}
}
