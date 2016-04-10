package Test;

import java.io.IOException;
import java.util.ArrayList;

import DataBase.DataClient;
import DataBase.DataOrder;
import DataBase.DataResto;
import DataBase.Serializer;
import Restaurant.Meal;
import Restaurant.Order;

/**
 * to test Order and Meal
 * @author kewenjing
 *
 */
public class TestOrder {
	
	public static void main(String [] args){
		Meal e=new Meal();
		e.setDish_name("Mixed garden salad");
		e.setIngredient_detail("drizzled with your choice of our homemade dressing served with bread");
		e.setPrice(2.2);
		e.setSpecial_price(1.5);
		e.setStock(100);
		System.out.println(e);
		
		Meal e1=new Meal("Spaghetti Bolognese"," with a lean meat sauce accompanied by grated parmesan cheese",3.2);
		System.out.println(e1.getPrice());
		
		
		Meal e2=new Meal();
		e2.setDish_name("Salmon Steak");
		e2.setIngredient_detail("baked with lemon grass herb butter and tomato-mussel coulis");
		e2.setPrice(5.0);
		e2.setStock(100);
		System.out.println(e2);
		
		Order order1=new Order("emma");
		order1.add_meal(e, 1);
		System.out.println(e);
		
		order1.add_meal(e2, 2);
		
		System.out.println(e2.getPrice());
		
		order1.check();
		System.out.println(order1);
		System.out.println(order1.getTot_price());
		//System.out.println(e);
		
		ArrayList<Order> all_order=new ArrayList<Order>();
		all_order.add(order1);
		System.out.println(all_order);
		DataOrder.Log_OrderData(all_order);
//		try {
//			Serializer.serialize(order1, DataClient.filePath+"Order_database.txt");
//		} catch (IOException e3) {
//			// TODO Auto-generated catch block
//			e3.printStackTrace();
//		}

		
	}
}
