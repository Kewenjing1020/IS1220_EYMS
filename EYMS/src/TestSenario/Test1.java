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

/**
 * succed in loging the new All_clients database
 * 
[Client [user_name=user_name1, first_name=first_name1, last_name=last_name1, password=password1, 
authorization=true, birthday=06/01, fidelityCard=BasicFidelityCard, 
contacter_names=[last_name1 first_name1, contactname1], 
email=[new_email1, new_email2], phone_number=[new_phone_number1, new_phone_number2, phonenumber3], 
address=[address1, address2, adress3], 
deliveryInfo=[Delivery [contactname=contactname1, phonenumber=phonenumber3, adress=adress3]], 
favorite_meals=null], 

Client [user_name=user_name2, first_name=first_name2, last_name=last_name2, password=password2, 
authorization=true, birthday=07/02, fidelityCard=PointFidelityCard [point=0], 
contacter_names=[last_name2 first_name2, contactname1], email=[new_email1, new_email2], 
phone_number=[new_phone_number1, new_phone_number2, phonenumber3], 
address=[address1, address2, adress3], 
deliveryInfo=[Delivery [contactname=contactname1, phonenumber=phonenumber3, adress=adress3]], 
favorite_meals=null], Client [user_name=user_name3, first_name=first_name3, last_name=last_name3, password=password3, authorization=true, birthday=07/03, fidelityCard=BasicFidelityCard, contacter_names=[last_name3 first_name3], email=[], phone_number=[], address=[], deliveryInfo=[], favorite_meals=null], Client [user_name=user_name4, first_name=first_name4, last_name=last_name4, password=password4, authorization=true, birthday=08/04, fidelityCard=PointFidelityCard [point=0], contacter_names=[last_name4 first_name4], email=[], phone_number=[], address=[], deliveryInfo=[], favorite_meals=null]]
true

succed in loging the new Al_Restaurant database

[Restaurant [Resto_name=resto1, password=resto_password, 
users=[Personnel [user_name=chef1username, first_name=chef1firstName, last_name=chef1lastName, password=chef1password]], 
meals=[Meal:dish_name1, ingredient_detail=ingredient_detail1, price=5.5, special_price=4.0, stock=10, quantity need for client=1, 
Meal:dish_name2, ingredient_detail=ingredient_detail2, price=5.5, special_price=4.0, stock=20, quantity need for client=1
]]]

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
