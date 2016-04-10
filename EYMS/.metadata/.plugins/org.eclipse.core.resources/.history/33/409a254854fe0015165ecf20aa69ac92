package Test;

import java.io.IOException;

import java.util.ArrayList;


import DataBase.DataResto;

import Restaurant.Meal;
import Restaurant.Personnel;
import Restaurant.Restaurant;

/**
 * to test DataBase.DataResto 
 * @author kewenjing
 *
 */
public class TestDataRetsto {
	

	public static void main(String [] args) throws IOException{
		Restaurant res1=new Restaurant("CHEZ LILY");
		Restaurant res2=new Restaurant("Antony");
		ArrayList<Restaurant> Restaurants=new ArrayList<Restaurant>();
		Restaurants.add(res1);
		Restaurants.add(res2);
		System.out.println(Restaurants);
		DataResto.Log_RestoData(Restaurants);
		
		
		//register a new personnel
		Personnel chef=new Personnel("chef", "imchef");
		DataResto.verify(Restaurants,chef.getUsername() );
		DataResto.Register(Restaurants, "Antony",chef );
		
		//register a new restaurant	
		DataResto.verifyResto(Restaurants, "CHEZ LILY");
		Restaurant res3=new Restaurant("WATHER");
		DataResto.RegisterResto(Restaurants, res3);
		
		Meal e=new Meal("snack","tomato",3.5);
		res2.createMeal(e);
		DataResto.print_RestoInfo(res2);
		
		//Login a personnel
		DataResto.Login(Restaurants, "chef", "imchef");
		
		DataResto.refresh_Data(res1, Restaurants);
		
		DataResto.refresh_Data(res2, Restaurants);
		DataResto.refresh_Data(res3, Restaurants);
		System.out.println(Restaurants);
		DataResto.Log_RestoData(Restaurants);
	
	}
}
