package CLUI;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DataBase.DataClient;
import DataBase.DataOrder;
import DataBase.DataResto;
import FidelityCard.LotteryFidelityCard;
import FidelityCard.PointFidelityCard;
import Restaurant.Meal;
import Restaurant.MealNotFoundException;
import Restaurant.Order;
import Restaurant.Restaurant;
import User.Client;

/**
 * 
 * @author kewenjing
 *
 */

public class CommandClient {
	
	public static void main(String [] args) throws IOException, MealNotFoundException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String delim="[ ,<>()]+";
		
		ArrayList<Client> all_clients= DataClient.Load_ClientData();

		Client curr_client=new Client();
		
		String answer = new String();
			
		
		/**
		 * step 1: login/register
		 */
//		while(true){	
//		System.out.println("Dear Sir/Miss, are you already registered in our site? (Y/N)");
//		answer = typein.readLine();
//		if(answer.equals("n")||answer.equals("N")){	
//			CL_clientLogin.Register_start(curr_client);
//			curr_client=CL_clientLogin.Register(all_clients,curr_client);
//			break;
//		}
//	
//		else if(answer.equals("Y")||answer.equals("y")){
//			CL_clientLogin.Login_start(curr_client);
//			curr_client=CL_clientLogin.Login(all_clients,curr_client);
//			System.out.println(curr_client);
//			break;
//		}else{
//			System.out.println("Invalid input");
//			continue;
//		}
//		}
		
		//delete after test
		curr_client=all_clients.get(0);
		System.out.println(curr_client);
		
		/**
		 * step 2: order a meal
		 */
		ArrayList<Restaurant> all_Resto=DataResto.Load_RestoData();
		Restaurant curr_resto=new Restaurant();
		DataResto.print_RestoInfo_All(all_Resto);
		Order curr_order=new Order(curr_client.getUser_name());
		
		//select a restaurant
		CL_clientOrder.selectResto_start();
		curr_resto=CL_clientOrder.selectResto(all_Resto, curr_resto);

		//delete after test
		curr_resto=all_Resto.get(0);
		
		//choose a meal
		Meal curr_meal=new Meal();
		
		
//		System.out.println("please choose a meal \n "
//				+ "type in the form of: selectResto < mealName, quantity>, quantity should be integer");
//		answer = typein.readLine();
//		String[] cmdline=answer.split(delim);
//		if(  cmdline[0].equals("mealName") && CL_clientLogin.isNumeric(cmdline[2])  
//				&& Restaurant.findMealName(cmdline[0], curr_resto.getMeals())
//				){	
//			
//		}
//		//selectResto < mealName, quantity>
//		curr_meal=curr_resto.findMealCorrespond(cmdline[1]);
//		curr_meal=curr_resto.selectMeal(curr_meal, Integer.parseInt(cmdline[2]));
//		
//
//		//currentMeal<>
//		System.out.println(curr_meal);
//		
//		//saveMeal<>
//		curr_order.saveMeal(curr_meal);
//		
//		System.out.println("type in the form of: addPersonalization< Personalization demands> ");
//		answer = typein.readLine();
//		//addPersonalization
//		curr_order.setPersonalization(answer);
		
		//add delivery
//		System.out.println("this is your delivery information stocked in the system ");
//		System.out.println(curr_client.getDeliveryInfo());
//		System.out.println("please choose or add a delivery information to this order");
//		System.out.println("in the form of : Delivery <contactname, phonenumber, adress");
//		answer = typein.readLine();
//		String[] cmdline=answer.split("[,<>]+");
//		curr_order.setDelivery_info(cmdline[1], cmdline[2], cmdline[3]);
//		System.out.println(curr_order.getDelivery_info());
//		
		//check
		curr_order.check();
		System.out.println(curr_order);
		
		//save the order to the database	
		DataOrder.Save_Order(curr_order);
		DataOrder.Load_OrderData();
		
		//refresh stock
		curr_resto.refreshStock(curr_order.getMeal_list());
		System.out.println(curr_resto);
	}
}
			

//			while(user_name.equals("a")){
//				System.out.println("this username is already registed");
//				System.out.println("please type in your user-name");
//				user_name = typein.readLine();
//			}
//			
//			System.out.println("plese set your password:(the password can include letters and Numbers only)");
//			String new_password=typein.readLine();
//			System.out.println("please type in your first-name");
//			String firstname=typein.readLine();
//			System.out.println("please type in your last-name");
//			String lastname=typein.readLine();
//			Client customer=new Client(user_name,new_password,firstname, lastname);
//			
//			System.out.println("your e-mail");
//			String email=typein.readLine();
//			customer.add_email(email);
//			System.out.println("your phone number");
//			String phone_number=typein.readLine();
//			customer.add_phone_number(phone_number);
//			System.out.println("your address");
//			String address=typein.readLine();
//			customer.add_address(address);
//			System.out.println("do you want receive general and/or person"
//					+ "alized (birthday special o↵ers, new meals alert, ...) promotions");
//
//			if(ans.equals("y")||ans.equals("Y")){
//				customer.setAuthorization(true);
//			}
//		
//			//verify information
//			System.out.println(customer);
//			
			
			//to store the info
			//register(nov_username, nov_first_name, nov_last_name,);
		
	
		
			
			
		
		
		/**
		 * login user
		 */
		
//		if(answer.equals("y")||answer.equals("Y")){			
//			System.out.println("login in");
//			System.out.println("username:");
//			user_name=typein.readLine();
//			System.out.println("password");
//			password=typein.readLine();
//			
//			
//			try {
//				thisCustomer = (Client) Serializer.deserialize( 
//						"/Users/kewenjing/Desktop/EYMS/Client_database/"+user_name+".txt");
//				
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//			//verify if the password is correct
//			
//			String true_password=thisCustomer.getPassword();
//			if(true_password.equals(password)){
//				System.out.println("welcome back!" +user_name);
//				}
//		}
//		
		//finish the login
		//login(username,password)  -> to login client's information
		
		/*
		 * step 2: ordering a meal
		 */
		
		//propose the available meals
//		System.out.println("list of your favorite meals");
//		System.out.println(thisCustomer.getFavorite_meals());
		//choose from his favorite list
		
		
		//choose a restaurant
		
		//open the restaurant_file
		
		//do the command
		
		//get price
		
		
		/**
		 * step3: verify the order
		 */
		
		//print out the order
		