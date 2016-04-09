package Restaurant;

import java.io.Serializable;
import java.util.ArrayList;

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
	private ArrayList<Personnel> users;
	private ArrayList<Meal> meals;
	
	


	@Override
	public String toString() {
		return "Restaurant [Resto_name=" + Resto_name + ", users=" + users + ", meals=" + meals + "]";
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
	
	
	public void createMeal(Meal e){
		int count=0;
		for(int i=0; i<this.getMeals().size();i++){
			if(this.getMeals().get(i).getDish_name().equals(e.getDish_name())){
				System.out.println("this meal already existe in your menu");
				
				count=1;
				break;
			}
				
		}
		if(count==0){
			this.getMeals().add(e);
			System.out.println("succed in add this meal");
		}
	}
}
