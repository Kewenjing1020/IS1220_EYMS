package TestSenario;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import DataBase.DataClient;
import DataBase.DataResto;
import FidelityCard.BasicFidelityCard;
import FidelityCard.PointFidelityCard;
import Restaurant.Meal;
import Restaurant.Order;
import Restaurant.Restaurant;
import User.Client;

/**
 * only for create a database of client and restaurant
 * don't copy for the CLUI 
 * the operation here is different of those in CLUI
 * @author kewenjing
 *
 */

public class Test1 {
	
	
	public static void main(String [] args) {
		
		//initialiser, clear the 
		new File("Client_database.txt").delete();
		new File("Order_database.txt").delete();
		
		//create client database
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
		
		
		//create resto database
		Restaurant res1=new Restaurant("resto1", "resto_password");
		res1.insertChef("chef1firstName", "chef1lastName", "chef1username", "chef1password");
		
		
		Meal e1=new Meal("dish_name1", "ingredient_detail1", 5.5);
		e1.setSpecial_price((double) 4);
		e1.setStock(10);
		
		Meal e2=new Meal("dish_name2", "ingredient_detail2", 5.5);
		e2.setSpecial_price((double) 4);
		e2.setStock(20);
		res1.createMeal(e1);
		res1.createMeal(e2);
		
		//create a ArrayList<Restaurant> Resto, read the Log RestoData
		ArrayList<Restaurant> Resto= new ArrayList<Restaurant>();
		Resto.add(res1);
		DataResto.Log_RestoData(Resto);
		
		
		
		
		
		
	
	}
}
