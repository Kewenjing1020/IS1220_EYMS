package DataBase;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Restaurant.Meal;
import Restaurant.Personnel;
import Restaurant.Restaurant;

/**
 * All the operation based on the Resto_database
 * @author kewenjing
 *
 */
public class DataResto {
	
	public static String filePath="/Users/kewenjing/Desktop/EYMS/";
	
	public static void main(String [] args) throws IOException{
		Restaurant res1=new Restaurant("CHEZ LILY");
		Restaurant res2=new Restaurant("Antony");
		ArrayList<Restaurant> Restaurants=new ArrayList<Restaurant>();
		Restaurants.add(res1);
		Restaurants.add(res2);
		System.out.println(Restaurants);
		Log_RestoData(Restaurants);
		
		
		//register a new personnel
		Personnel chef=new Personnel("chef", "imchef");
		verify(Restaurants,chef.getUsername() );
		Register(Restaurants, "Antony",chef );
		
		//register a new restaurant	
		verifyResto(Restaurants, "CHEZ LILY");
		Restaurant res3=new Restaurant("WATHER");
		RegisterResto(Restaurants, res3);
		
		Meal e=new Meal("snack","tomato",3.5);
		res2.createMeal(e);
		print_RestoInfo(res2);
		
		//Login a personnel
		Login(Restaurants, "chef", "imchef");
		
		refresh_Data(res2, Restaurants);
		Log_RestoData(Restaurants);
		
	}
	
	



	/**
	 * register a new resto
	 * @param restaurants
	 * @param e
	 */
	public static void RegisterResto(ArrayList<Restaurant> restaurants, Restaurant e) {
		// TODO Auto-generated method stub
		restaurants.add(e);
		
	}


	/**
	 * open the Restaurant database, load the All_Restaurant info, before all the operation
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Restaurant> Load_RestoData(){
		ArrayList<Restaurant> all_Resto=new ArrayList<Restaurant>();
		//open the file, deserialize the client_data
		try {
   
            /**
             * Deserializing the object
             */
            all_Resto = (ArrayList<Restaurant>) Serializer.deserialize(filePath+"Restaurant_database.txt");
            System.out.println("succed in loading the new All_resto database");
            System.out.println(all_Resto);
          
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error: fail to load the All_resto data");
        }
		return all_Resto;
	}
	
	
	/**
	 * after all the operation
	 * rewrite the All_Restaurant information into database
	 * @param Restaurants
	 */
	public static void Log_RestoData(ArrayList<Restaurant> Restaurants){
		//open the file, serialize the Restaurant_data
		try {
            /**
             *  Serializing the object
             */
			boolean delete=new File(filePath+"Restaurant_database.txt").delete();
			System.out.println(delete);
            Serializer.serialize(Restaurants, filePath+"Restaurant_database.txt");
			
	        
            System.out.println("succed in loging the new Al_Restaurant database");
            System.out.println(Restaurants);
          
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error: fail to log the new All_Restaurants database");
        }
//		return Restaurants;
	}
	
	/**
	 * every time after the change, save change to database
	 * @param Restaurants
	 * @return
	 */
	public static ArrayList<Restaurant> save_change(ArrayList<Restaurant> Restaurants){
		Log_RestoData(Restaurants);
		return Restaurants;
	}
	
	
	/**
	 * find the restaurant which this user is in
	 * find restaurant by the username
	 * @param All_Restaurants
	 * @param username
	 * @return
	 */
	public static Restaurant find_resto_in(ArrayList<Restaurant> All_Restaurants, String username){
		Restaurant curr_resto=new Restaurant();
		for(int i=0; i<All_Restaurants.size();i++ ){
			curr_resto=(Restaurant)All_Restaurants.get(i);
			for(int j=0; j<curr_resto.getUsers().size();j++){
				if(curr_resto.getUsers().get(j).getUsername().equals(username)){
					return curr_resto;
				}
			}
		}
		System.out.println("error: fail to find which restaurant you are in");
		return null;
	}
	
	/**
	 * find restaurant by resto_name
	 * @param All_Restaurants
	 * @param resto_name
	 * @return
	 */
	public static Restaurant find_resto(ArrayList<Restaurant> All_Restaurants, String resto_name){
		Restaurant curr_resto=new Restaurant();
		for(int i=0; i<All_Restaurants.size();i++ ){
			curr_resto=(Restaurant)All_Restaurants.get(i);
				if(curr_resto.getResto_name().equals(resto_name)){
					return curr_resto;	
			}
		}
		System.out.println("error: fail to find this restaurant:"+resto_name);
		return null;
		
	}
	
	
	/**
	 * to make sure the username of the personnel is unique
	 * @param All_Restaurants
	 * @param username
	 * @return
	 */
	public static Boolean verify(ArrayList<Restaurant> All_Restaurants, String username){
		for(int i=0; i<All_Restaurants.size();i++ ){
			Restaurant Restaurant=(Restaurant)All_Restaurants.get(i);
			
			if(Restaurant.getUsers()==null){
				return true;
			}
			else{
				for(int j=0; j< Restaurant.getUsers().size();j++){
					if(Restaurant.getUsers().get(j).getUsername().equals(username))
					{
						System.out.println("error: this username is already used in your restaurant");
						return false;
					}
				}
			}
			
		}
		return true;
	}
	
	
	/**
	 * verify Resto_name is unique
	 * @param All_Restaurants
	 * @param Resto_name
	 * @return
	 */
	public static Boolean verifyResto(ArrayList<Restaurant> All_Restaurants, String Resto_name){
		for(int i=0; i<All_Restaurants.size();i++ ){
			Restaurant Restaurant=(Restaurant)All_Restaurants.get(i);
			//find this restaurant
			if(Restaurant.getResto_name().equals(Resto_name)){
				System.out.println("error: this restaurant name is already used in our web, please use another name");
				return false;
				
			}
		}
		return true;
	}
	

	
	/**
	 * Register a new personnel of an existing restaurant
	 * Add this user in the database
	 * @param All_Restaurants
	 * @param Resto_name
	 * @param personnel
	 * @return
	 */
	public static ArrayList<Restaurant> Register(ArrayList<Restaurant>  All_Restaurants,  String Resto_name, Personnel personnel){
		Restaurant curr_resto=find_resto(All_Restaurants, Resto_name);
		curr_resto.getUsers().add(personnel);
		System.out.println("succed in registering!");
		return All_Restaurants;
		
	}
	
	
	/**
	 * traverse the All_restaurants,  to find this resto
	 * get this user's information
	 * @param All_Restaurants
	 * @param username
	 * @param password
	 * @return
	 */
	public static Restaurant Login(ArrayList<Restaurant> All_Restaurants, String username, String password) {
		Restaurant curr_resto=find_resto_in(All_Restaurants, username);
		for(int j=0; j<curr_resto.getUsers().size();j++){
			if(curr_resto.getUsers().get(j).getUsername().equals(username) && curr_resto.getUsers().get(j).getPassword().equals(password)){
				return curr_resto;
			}
		}
		
		System.out.println("error:cannot find the user");
		return null;
	}
	
	
	
	/**
	 * print this client's favorite meals
	 * @param client
	 */
	public static void print_RestoInfo(Restaurant curr_resto){
		System.out.println(curr_resto.getMeals());
		//print stock of ingredient
	}
	
	public static void print_tout_menu(){
		Load_RestoData();
		
	}
	
	
	
	/**
	 * refresh Restaurant_data in Arraylist All_Restaurants
	 * @param Restaurant
	 * @param All_Restaurants
	 * @return
	 */
	public static ArrayList<Restaurant> refresh_Data(Restaurant Restaurant, ArrayList<Restaurant> All_Restaurants){
		for(int i=0; i<All_Restaurants.size();i++ ){
			if(All_Restaurants.get(i).getResto_name().equals(Restaurant.getResto_name())){
				
				All_Restaurants.set(i, Restaurant);
				System.out.println("succed in load restaurant's new info");
				return All_Restaurants;
			}
		
		}
		System.out.println("fail in load restaurant's new info");
		return All_Restaurants;
	}

	
}
