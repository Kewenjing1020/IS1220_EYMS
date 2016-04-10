package CLUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DataBase.DataClient;
import DataBase.DataResto;
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
		
		ArrayList<Client> all_clients= DataClient.Load_ClientData();
		ArrayList<Restaurant> all_Resto=DataResto.Load_RestoData();
		
		
		Client curr_client=new Client();
		
		String answer = new String();
			
		
		/**
		 * step 1: login/register
		 */
		while(true){	
		System.out.println("Dear Sir/Miss, are you already registered in our site? (Y/N)");
		answer = typein.readLine();
		if(answer.equals("n")||answer.equals("N")){	
			CL_clientLogin.Register_start(curr_client);
			curr_client=CL_clientLogin.Register(all_clients,curr_client);
			break;
		}
	
		else if(answer.equals("Y")||answer.equals("y")){
			CL_clientLogin.Login_start(curr_client);
			curr_client=CL_clientLogin.Login(all_clients,curr_client);
			System.out.println(curr_client);
			break;
		}else{
			System.out.println("Invalid input");
			continue;
		}
		}
		
		
		/**
		 * step 2: order a meal
		 */
		
		Restaurant curr_resto=new Restaurant();
		DataResto.print_RestoInfo_All(all_Resto);
		Order curr_order=new Order(curr_client.getUser_name());
		
		//select a restaurant
		CL_clientOrder.selectResto_start();
		curr_resto=CL_clientOrder.selectResto(all_Resto, curr_resto);

		//choose a meal
		curr_order=CL_clientOrder.addMeal(curr_resto,curr_order);
		
		//addPersonalization
		CL_clientOrder.addPersonalization_start();
		curr_order=CL_clientOrder.addPersonalization(curr_order);
		
		//add delivery
		CL_clientOrder.addDelivery_start(curr_client);
		curr_order=CL_clientOrder.addDelivery(curr_order,curr_client);
		
		
		//check
		
		System.out.println(curr_order);
		
		//refresh and save the database
		DataResto.refresh_Data(curr_resto, all_Resto);
		DataResto.Log_RestoData(all_Resto);
		DataClient.refresh_clientdata(curr_client, all_clients);
		DataClient.Log_ClientData(all_clients);

		
		System.out.println(curr_resto);
	}
}
			

		