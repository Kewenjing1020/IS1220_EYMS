package RestoChain;

import java.util.ArrayList;


import DataBase.DataClient;
import DataBase.DataResto;
import Operation.ClientObservable;
import Restaurant.Meal;
import Restaurant.Restaurant;
import User.Client;

public class RestoChain extends Thread implements ClientObservable{
	
	private ArrayList<Client> allClients;
	private ArrayList<Restaurant> allRestaurant;
	private String date;

	
	public static void main(String[] args) {
		RestoChain restoChain = new RestoChain();
		
		System.out.println(restoChain.getAllRestaurant());
		

	}

	
	/**
	 * Constructor
	 */
	public RestoChain() {
		super();
		allClients = DataClient.Load_ClientData();
		allRestaurant = DataResto.Load_RestoData();
		date = new String("10/04/2016");
		//We automatically notify the clients when we create the RestoChain
		this.notifyAd();
		this.notifyBirthday();		
	}

	/**
	 * Constructor
	 * @param beginDate
	 */
	public RestoChain(String beginDate) {
		super();
		allClients = DataClient.Load_ClientData();
		allRestaurant = DataResto.Load_RestoData();
		date = new String(beginDate);
		//We automatically notify the clients when we create the RestoChain
		this.notifyAd();
		this.notifyBirthday();		
	}
	
	

	/**
	 * Method to notify special price to any client who want to receive them
	 */
	@Override
	public void notifyAd() {
		ArrayList<String> ads = new ArrayList<String>();
		//We register all the available offers in ads
		for(Restaurant resto : allRestaurant){
			for(Meal meal : resto.getMeals()){
				if (meal.getSpecial_price() != -1.0){
					ads.add(new String("Come and get Meal " + meal.getDish_name() 
					+ " for only " + meal.getSpecial_price() + "euros !"));
				}
			}
			}
		//We contact clients who authorize the chain to send them the special offers available
		for(Client client : allClients){
			if(client.getAuthorization()){
				client.update(ads);
			}
		}
	}
	
	/**
	 * Method to notify birthday offer to any client who want to receive them
	 */
	@Override
	public void notifyBirthday() {
		//We send special offer to the client whom it's the birthday
		for(Client client : allClients){
			if(client.getBirthday().contains(date.subSequence(0, 4))){
				ArrayList<String> ads = new ArrayList<String>();
				ads.add(new String("Happy Birthday to you " + client.getUsername()
				+ "You can benefit from a special offer today"));
				client.update(ads);
			}
		}
	}


	public ArrayList<Client> getAllClients() {
		return allClients;
	}


	public void setAllClients(ArrayList<Client> allClients) {
		this.allClients = allClients;
	}


	public ArrayList<Restaurant> getAllRestaurant() {
		return allRestaurant;
	}


	public void setAllRestaurant(ArrayList<Restaurant> allRestaurant) {
		this.allRestaurant = allRestaurant;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}

	

}
