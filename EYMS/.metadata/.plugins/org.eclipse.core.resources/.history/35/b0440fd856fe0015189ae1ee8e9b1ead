package Restaurant;

import java.io.Serializable;
import java.util.ArrayList;

import Part1.Delivery;

/**
 * 
 * @author kewenjing
 *
 */
public class Order implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8776393638656209850L;
	
	
	private ArrayList<Meal> meal_list;
	private Double tot_price;
	//leave the message for the special demand of the meals
	private String personalization;
	private Delivery delivery_info;
	private String client_username;
	





	/**
	 * @param meal_list
	 * @param tot_price
	 */
	public Order(String client_username) {
		super();
		this.client_username=client_username;
		this.meal_list = new ArrayList<Meal>();
		this.tot_price=(double) 0;
		this.personalization=null;
	}

	

	@Override
	public String toString() {
		return "Order [client_username=" + client_username +", meal_list=" + meal_list + ", tot_price=" + tot_price + ", personalization=" + personalization
				+ ", delivery_info=" + delivery_info + "]\n";
	}








	public void add_meal(Meal e,int qty){
		if (e.stock>=qty){
			e.quantity=qty;
			e.stock-=qty;
			meal_list.add(e);
			System.out.println(e.quantity+ " shares of "+ e.getDish_name()+" in your cart now");
			
		}
		else if(e.stock==0){
			System.out.println("this meal is sold out ");
		}else{
			System.out.println("there are "+ e.stock+"shares in stock, please change the quantity you need");
		}
		
	}
	
	public void remove_meal(Meal e){
		meal_list.remove(e);
	}
	
	
	
	//getter and setter
	public ArrayList<Meal> getMeal_list() {
		return meal_list;
	}

	public void setMeal_list(ArrayList<Meal> meal_list) {
		this.meal_list = meal_list;
	}

	public Double getTot_price() {
		return tot_price;
	}

	public void setTot_price(Double tot_price) {
		
		this.tot_price=tot_price;
	}
	
	/**
	 * check out, calculate the total price
	 */
	public void check(){
		for(int i=0;i<this.getMeal_list().size();i++){
			Meal curr_meal=this.getMeal_list().get(i);
			this.tot_price += curr_meal.getPrice()*curr_meal.quantity;	
		}
	}

	public String getPersonalization() {
		return personalization;
	}

	public void setPersonalization(String personalization) {
		this.personalization = personalization;
	}

	public Delivery getDelivery_info() {
		return delivery_info;
	}

	public void setDelivery_info(Delivery delivery_info) {
		this.delivery_info = delivery_info;
	}
	public String getClient_username() {
		return client_username;
	}
	public void setClient_username(String client_username) {
		this.client_username = client_username;
	}
	
	
}
