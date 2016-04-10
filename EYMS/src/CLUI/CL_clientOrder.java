package CLUI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import DataBase.DataResto;
import Restaurant.Meal;
import Restaurant.Order;
import Restaurant.Restaurant;
import User.Client;

public class CL_clientOrder {
	
	static String delim="[ ,<>()]+";
	
	public static void selectResto_start(){
		System.out.println("please choose a restaurant \n "
				+ "type in the form of: selectResto < restoName>");
	}
	public static Restaurant selectResto(ArrayList<Restaurant> all_Resto, Restaurant curr_resto) throws IOException{
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		if(cmdline.length!=2){
			System.out.println("Invalid input ");
			selectResto_start();
			selectResto(all_Resto, curr_resto);
		}
		if(cmdline[0].equals("selectResto") && DataResto.tryfind_resto(all_Resto,cmdline[1])){
			curr_resto=DataResto.find_resto(all_Resto, cmdline[1]);
			curr_resto.printMenuForClient();
		}else{
			System.out.println("Invalid input ");
			selectResto_start();
			selectResto(all_Resto, curr_resto);
		}
		
		return curr_resto;
		
	}
	
	
	public static void selectMeal_start(Order curr_order){
		System.out.println("please choose a meal \n "
				+ "type in the form of: selectMeal < mealName, quantity>, quantity should be integer");
//		if(curr_order.getMeal_list().size()!=0){
//			System.out.println("or type in: skip, to next step ");
//		}
		
	}
	public static Meal selectMeal(Restaurant curr_resto, Order curr_order) throws IOException{
		Meal curr_meal=new Meal();
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
	
		if(cmdline.length!=3){
			System.out.println("Invalid input in selectMeal");
			selectMeal_start(curr_order);
			selectMeal(curr_resto, curr_order);
		}
		else if(  cmdline[0].equals("selectMeal") && CL_clientLogin.isNumeric(cmdline[2])
				&& cmdline.length==3 && Restaurant.findMealName(cmdline[1], curr_resto.getMeals())
				){	
			System.out.println("find");
			//selectResto < mealName, quantity>
			curr_meal=curr_resto.findMealCorrespond(cmdline[1]);
			if(curr_order.getMeal_list().contains(curr_meal)){
				for (int i =0; i<curr_order.getMeal_list().size();i++)
				{
					if( curr_order.getMeal_list().get(i).getDish_name().equals(cmdline[1]) ){
						Integer oldQty=curr_order.getMeal_list().get(i).getQuantity();
						Integer oldStk=curr_meal.getStock();
						curr_order.getMeal_list().get(i).setQuantity(oldQty+Integer.parseInt(cmdline[2]));
						curr_meal.setStock(oldStk-Integer.parseInt(cmdline[2]));
						System.out.println("ok");
						break;
					}
					
				}
			}
			else{
				curr_meal=curr_resto.selectMeal(curr_meal, Integer.parseInt(cmdline[2]));
			}
			
		}else if(answer.equals("skip")){
			return curr_meal;
		}else{
			System.out.println("Invalid input in selectMeal");
			selectMeal_start(curr_order);
			selectMeal(curr_resto, curr_order);
		}
		

		return curr_meal;
	
	
	}
	
	public static void saveMeal_start(){
		System.out.println("you can type in: currentMeal<>");
		System.out.println("or type in: saveMeal<>");
			
	}
	public static Order saveMeal(Meal curr_meal, Order curr_order, Restaurant curr_resto) throws IOException{
	
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		
		
		if(answer.equals("currentMeal<>")){
			//currentMeal<>
			saveMeal_start();
			saveMeal(curr_meal, curr_order, curr_resto);
		}else if(answer.equals("saveMeal<>")){
			//saveMeal<>
			curr_order.saveMeal(curr_meal);
			curr_resto.refreshStock(curr_order.getMeal_list());
		}else{
			System.out.println("Invalid input in saveMeal");
			saveMeal_start();
			saveMeal(curr_meal, curr_order, curr_resto);
		}
		return curr_order;
		
	}
	
	public static void addMeal_start(Order curr_order){
		System.out.println("current order : "+ curr_order.getMeal_list());
		System.out.println("you can type in: selectMeal < mealName, quantity> , to add another meal");
		System.out.println("or type in: saveOrder<> , to checked out");
			
	}
	public static Order addMeal(Restaurant curr_resto, Order curr_order) throws IOException{
		Meal curr_meal=new Meal();
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));

		
		selectMeal_start(curr_order);
		curr_meal=selectMeal(curr_resto, curr_order);
		
		saveMeal_start();
		curr_order=saveMeal(curr_meal, curr_order,curr_resto);
		
		addMeal_start(curr_order);
		String answer = typein.readLine();
		String[] cmdline=answer.split(delim);
		if(  cmdline[0].equals("selectMeal") && CL_clientLogin.isNumeric(cmdline[2])  
				&& Restaurant.findMealName(cmdline[1], curr_resto.getMeals())
				){	
			curr_order=addMeal(curr_resto,curr_order);
		}else if(answer.equals("saveOrder<>")){
			curr_order.check();
			return curr_order;
		}else{
			System.out.println("Invalid input in addMeal");
			addMeal_start(curr_order);
			addMeal(curr_resto, curr_order);
		}
		//System.out.println(curr_resto);
		return curr_order;
		
	}
	
	
	public static void addDelivery_start(Client curr_client){
		System.out.println("this is your delivery information stocked in the system ");
		System.out.println(curr_client.getDeliveryInfo());
		System.out.println("please choose or add a delivery information to this order");
		System.out.println("in the form of : Delivery <contactname, phonenumber, adress");
	}
	public static Order addDelivery(Order curr_order,Client curr_client) throws IOException{
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split("[,<>]+");
		
		if(cmdline[0].equals("Delivery") && cmdline.length==4 ){
			curr_order.setDelivery_info(cmdline[1], cmdline[2], cmdline[3]);
			System.out.println(curr_order.getDelivery_info());
		}else{
			System.out.println(cmdline.length);
			System.out.println("Invalid input");
			addDelivery_start(curr_client);
			addDelivery(curr_order,curr_client);
		}
		
		
		return curr_order;
		
	}
	
	public static void addPersonalization_start(){
		System.out.println("type in the form of: addPersonalization< Personalization demands> ");
		
	}
	public static Order addPersonalization(Order curr_order) throws IOException{
		
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		String answer = typein.readLine();
		String[] cmdline=answer.split("[ <>]+");
		
		if(cmdline[0].equals("addPersonalization") ){
			curr_order.setPersonalization(answer);
		}else{
			System.out.println("Invalid input");
			 addPersonalization_start();
			 addPersonalization(curr_order);
		}
		
		return curr_order;
	}
}
