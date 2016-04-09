package DataBase;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import Restaurant.Order;

/**
 * All the operation based on the Order_database
 * every time an order is made, stored in Order_database
 * @author kewenjing
 *
 */
public class DataOrder {
	

	public static void Save_Order(Order e){
		ArrayList<Order> Orders=new ArrayList<Order>();
		Load_OrderData();
		Orders.add(e);
		Log_OrderData(Orders);
	}
	
	
	/**
	 * log/write in the orders into Order_database
	 * @param Orders
	 */
	public static void Log_OrderData(ArrayList<Order> Orders){
		//open the file, serialize the Order_data
		try {
            /**
             *  Serializing the object
             */
			new File(DataClient.filePath+"Order_database.txt").delete();
            Serializer.serialize(Orders, DataClient.filePath+"Order_database.txt");
            System.out.println("succed in loging the new Order database");
            System.out.println(Orders);
          
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("error: fail to log the new Order database");
        }
	}
	
	/**
	 * read the order database
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static ArrayList<Order> Load_OrderData(){
		ArrayList<Order> Orders=new ArrayList<Order>();
		//open the file, deserialize the Order_data
		try {
            /**
             * Deserializing the object
             */
			Orders = (ArrayList<Order>) Serializer.deserialize(DataClient.filePath+"Order_database.txt");
            System.out.println("succed in loading the new Order database");
            System.out.println(Orders);
          
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("error: fail to load the Order data");
        }
		return Orders;
	}
	
	
}
