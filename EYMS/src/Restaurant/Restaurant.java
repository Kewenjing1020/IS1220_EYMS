package Restaurant;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.ArrayList;

import User.Personnel;
import User.User;

/**
 * 
 * @author kewenjing
 *
 */
public class Restaurant implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6668237868582090096L;
	/*
	 * Attributes
	 */
	private String Resto_name;
	private String Resto_password;
	private ArrayList<Personnel> users;
	private ArrayList<Meal> meals;
	
	


	@Override
	public String toString() {
		return "Restaurant [Resto_name=" + Resto_name + ", password="+Resto_password+", users=" + users + ", meals=" + meals + "]";
	}
	
	
	public Restaurant(String resto_name, String resto_password) {
		super();
		Resto_name = resto_name;
		Resto_password = resto_password;
		this.meals=new ArrayList<Meal>();
		this.users=new ArrayList<Personnel>();
	}

	
	public void printMenuForClient(){
		System.out.println("Restaurant : "+ this.Resto_name);
		for(int j=0; j<this.getMeals().size();j++){
			Meal e=this.getMeals().get(j);
			System.out.println("mealname:"+e.getDish_name()+"  price:"+e.getPrice()+"   special price:"+ e.getSpecial_price()+ "   stock:"+e.getStock()+"  \nIngredient detail: "+e.getIngredient_detail()+"");
		}
	}

	/*
	 * Getters and Setters
	 */
	public ArrayList<Personnel> getUsers() {
		return users;
	}
	public String getResto_name() {
		return Resto_name;
	}
	public void setResto_name(String resto_name) {
		Resto_name = resto_name;
	}
	public void setUsers(ArrayList<Personnel> users) {
		this.users = users;
	}

	public ArrayList<Meal> getMeals() {
		return meals;
	}
	public void setMeals(ArrayList<Meal> meals) {
		this.meals = meals;
	}
	
	
	/**constructor
	 * @param resto_name
	 */
	public Restaurant(String resto_name) {
		super();
		this.Resto_name = resto_name;
		this.meals=new ArrayList<Meal>();
		this.users=new ArrayList<Personnel>();
	}
	/**
	 * 
	 */
	public Restaurant() {
		super();
		this.meals=new ArrayList<Meal>();
		this.users=new ArrayList<Personnel>();
	}
	
	

	public void insertChef(String firstName,String lastName, String username, String password){
		Personnel chef=new Personnel(firstName, lastName, username, password);
		if(this.getUsers().contains(chef)){
			System.out.println("this chef already existe in the restaurant");
			
		}else 
			this.users.add(chef);
		
	}
	
	public void createMeal(Meal e){
		this.meals.add(e);
	}
	
	public Meal createMeal(String Mealname, Double price){
		
		for(int i=0; i<this.getMeals().size();i++){
			if(this.getMeals().get(i).getDish_name().equals(Mealname)){
				System.out.println("this meal already existe in your menu");
				
				
				return null;
			}		
		}
		Meal e=new Meal();
		e.setDish_name(Mealname);
		e.setPrice(price);
		this.getMeals().add(e);
			
		System.out.println("succed in add this meal");
		return e;
	}
//	
//	public Meal addIngredient (Meal e,String ingredientDetail){
//		e.setIngredient_detail(ingredientDetail);
//		return e;
//	}
	
	public void putInSpecialOffer(String mealName, Double price){
		for(int i=0; i<this.meals.size();i++){
			if(this.getMeals().get(i).getDish_name().equals(mealName)){
				this.getMeals().get(i).setSpecial_price(price);
				
			}
		}
		
	}
	
	public Meal selectMeal(Meal e,int qty){
		if (e.stock>=qty){
			e.quantity=qty;
			e.stock-=qty;
			System.out.println(e.quantity+ " shares of "+ e.getDish_name()+" in your cart now");
		}
		else if(e.stock==0){
			System.out.println("this meal is sold out ");
		}else{
			System.out.println("there are "+ e.stock+"shares in stock, please change the quantity you need");
		}
		return e;
		
	}
	
	public static Boolean findMealName(String mealName,ArrayList<Meal> mealList){
		for(int i=0; i<mealList.size();i++){
			if(mealList.get(i).getDish_name().equals(mealName)){
				return true;
			}
		}
		return false;
	}
	
	public Meal findMealCorrespond(String mealName) {
		Meal e =new Meal();
			int count =0;
			for(int i=0; i<this.meals.size();i++){
				if(this.getMeals().get(i).getDish_name().equals(mealName)){
					e=this.getMeals().get(i);
					count++;
					break;
				}
			}
			if (count==0){
				System.out.println("this meal doesn't in the meal list");
			}
	
		return e;
		
	}
	
	public Restaurant refreshStock(ArrayList<Meal> meal_list){
		for(int i=0; i<meal_list.size(); ++i){
			for(int j=0; j<this.meals.size(); ++j){
				if(this.meals.get(j).getDish_name().equals(meal_list.get(i).getDish_name())){
					this.meals.get(j).setStock( meal_list.get(i).getStock() );
					break;
				}
			}
		}
		return this;
	}
	
	
	public void removeFromSpecialOffer (String mealName) throws IOException{
		BufferedReader typein = new BufferedReader(new InputStreamReader(System.in));
		Meal e=new Meal();
		try{
			e=findMealCorrespond(mealName);
			
		}
		finally{
			e.setSpecial_price((double) -1);
		}

	}


	public String getResto_password() {
		return Resto_password;
	}


	public void setResto_password(String resto_password) {
		Resto_password = resto_password;
	}
}
