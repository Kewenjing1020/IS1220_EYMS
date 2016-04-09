package User;


import java.util.ArrayList;  
import FidelityCard.BasicFidelityCard;
import FidelityCard.FidelityCardVisitor;
import Operation.ClientObserver;
import Operation.LoginClient;
import Operation.RegisterClient;
import Restaurant.Meal;

/**
 * Client class which inherits from the class User
 * @author Lucas
 *
 */

public class Client extends User implements ClientObserver{
	
	
	private static final long serialVersionUID = 1861962790473617015L;
	
	private Boolean authorization = false;
	private String birthday = " ";
	private FidelityCardVisitor fidelityCard;

	private ArrayList<String> contacter_names;
	private ArrayList<String> email;
	private ArrayList<String> phone_number;
	private ArrayList<String> adress;
	private ArrayList<Meal> favorite_meals;
	
	/**
	 * 
	 */
	@Override
	public void update(ArrayList<String> ads) {
		if(this.email != null){
			for(String ad : ads){
				this.email.add(ad);
			}		
		}
		if(this.phone_number != null){
			for(String ad : ads){
				this.phone_number.add(ad);
			}		
		}
		if(this.adress != null){
			for(String ad : ads){
				this.adress.add(ad);
			}		
		}
	}
	
	/**
	 * getPrice method according to the price policy of EYMS
	 * the price of a meal depends of the fidelity card belonging 
	 * to the client
	 * @param meal
	 * @return
	 */
	public Double getPrice(Meal meal){
		Double price = this.fidelityCard.getPriceVisit(meal);
		return price;
	}
	
	
	/**
	 * toString method
	 */

	@Override
	public String toString() {
		return "Customer [user_name=" + user_name + ", password=" + password + ", first_name=" + first_name
				+ ", last_name=" + last_name + ", fidelityCard=" + fidelityCard + ", email=" + email + ", phone_number="
				+ phone_number + ", adress=" + adress + ", favorite_meals=" + favorite_meals + "]";
	}



	/**
	 * 
	 */
	public Client() {
		super();
		this.authorization=false;
		this.login = new LoginClient();
		this.register = new RegisterClient();
		this.fidelityCard = new BasicFidelityCard();
	}

	/**
	 * 
	 * @param fidelityCard
	 */
	public Client(FidelityCardVisitor fidelityCard){
		super();
		this.fidelityCard = fidelityCard;
	}

	/**
	 * @param user_name
	 * @param password
	 */
	public Client(String user_name,String password) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.email = new ArrayList<String>();
		this.phone_number = new ArrayList<String>();
		this.adress = new ArrayList<String>();
		this.authorization=false;
		this.contacter_names=new ArrayList<String>();
		this.login = new LoginClient();
		this.register = new RegisterClient();
		this.fidelityCard = new BasicFidelityCard();
	}
	
	
	/**
	 * @param user_name
	 * @param password
	 * @param first_name
	 * @param last_name
	 */
	public Client(String user_name, String password, String first_name, String last_name) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.first_name =first_name;
		this.last_name = last_name;
		this.email = new ArrayList<String>();
		this.phone_number = new ArrayList<String>();
		this.adress = new ArrayList<String>();
		this.authorization=false;
		this.contacter_names=new ArrayList<String>();
		contacter_names.add(last_name+" "+first_name);
		this.login = new LoginClient();
		this.register = new RegisterClient();
		this.fidelityCard = new BasicFidelityCard();
		
	}
	
	public void addPoint(int points){
		this.fidelityCard.point += points;		
	}
	
	public void removePoint(int points){
		this.fidelityCard.point -= points;		
	}
	
	public void setPoint(int points){
		this.fidelityCard.point = points;
	}
	
	/**
	 * 
	 * @param new_email
	 */
	public void add_email(String new_email){
		
		this.email.add(new_email);	
	}
	
	public void add_phone_number(String new_phone_number){
		this.phone_number.add(new_phone_number);
	}
	
	public void add_adress(String new_adress){
		this.adress.add(new_adress);
	}
	
	public void add_favorite_meal(Meal meal){
		this.favorite_meals.add(meal);
	}
	

	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public ArrayList<String> getEmail() {
		return email;
	}
	public void setEmail(ArrayList<String> email) {
		this.email = email;
	}
	public ArrayList<String> getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(ArrayList<String> phone_number) {
		this.phone_number = phone_number;
	}
	public ArrayList<String> getAdress() {
		return adress;
	}
	public void setAddress(ArrayList<String> adress) {
		this.adress = adress;
	}
	

	public ArrayList<Meal> getFavorite_meals() {
		return favorite_meals;
	}


	public void setFavorite_meals(ArrayList<Meal> favorite_meals) {
		this.favorite_meals = favorite_meals;
	}
	
	public Boolean getAuthorization() {
		return authorization;
	}



	public void setAuthorization(Boolean authorization) {
		this.authorization = authorization;
	}

	
	public String getBirthday() {
		return birthday;
	}



	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}



	public ArrayList<String> getGuest_names() {
		return contacter_names;
	}



	public void setGuest_names(ArrayList<String> guest_names) {
		this.contacter_names = guest_names;
	}



	public ArrayList<String> getContacter_names() {
		return contacter_names;
	}



	public void setContacter_names(ArrayList<String> contacter_names) {
		this.contacter_names = contacter_names;
	}


	
	
	
}
