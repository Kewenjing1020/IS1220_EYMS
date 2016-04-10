package User;


import java.util.ArrayList; 


import FidelityCard.BasicFidelityCard;
import FidelityCard.FidelityCardVisitor;
import Operation.ClientObserver;
import Part1.Delivery;
import Restaurant.Meal;

/**
 * Client class which inherits from the class User
 * @author Lucas
 *
 */

public class Client extends User implements ClientObserver{
	
	
	private static final long serialVersionUID = 1861962790473617015L;
	
	//I have suppressed the attribute point because it is include to fidelity card
	//furthermore all client doesn't have point, only those you have the PointFidelityCard
	//private int points;
	private Boolean authorization = false;
	private String birthday = " ";
	private FidelityCardVisitor fidelityCard;

	public FidelityCardVisitor getFidelityCard() {
		return fidelityCard;
	}

	public void setFidelityCard(FidelityCardVisitor fidelityCard) {
		this.fidelityCard = fidelityCard;
	}



	private ArrayList<String> contacter_names;
	private ArrayList<String> email;
	private ArrayList<String> phone_number;
	private ArrayList<String> address;
	private ArrayList<Meal> favorite_meals;

	private ArrayList<Delivery> deliveryInfo;
	
	/**
	 * 
	 */
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
		if(this.address != null){
			for(String ad : ads){
				this.address.add(ad);
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





	public Client() {
		super();
<<<<<<< HEAD
=======
		this.login = new LoginClient();
		this.register = new RegisterClient();
		this.fidelityCard = new BasicFidelityCard();
>>>>>>> 64b066b74918337b65dc7a82db04b4322fbd28d3
	}
	

	@Override
	public String toString() {
		return "Client [user_name=" + user_name + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", password=" + password + ", authorization=" + authorization + ", birthday=" + birthday + ", fidelityCard=" + fidelityCard
				+ ", contacter_names=" + contacter_names + ", email=" + email + ", phone_number=" + phone_number
				+ ", address=" + address + ", deliveryInfo="+deliveryInfo+", favorite_meals=" + favorite_meals + "]";
	}

	
	
	public Client(String user_name, String password, String first_name, String last_name,Boolean authorization, String birthday, FidelityCardVisitor fidelityCard) {
		super();
		this.authorization = authorization;
		this.birthday = birthday;
		this.fidelityCard = fidelityCard;
		this.user_name = user_name;
		this.password = password;
		this.first_name =first_name;
		this.last_name = last_name;
		this.email = new ArrayList<String>();
		this.phone_number = new ArrayList<String>();
		this.address = new ArrayList<String>();
		this.authorization=true;
		this.contacter_names=new ArrayList<String>();
		contacter_names.add(last_name+" "+first_name);
		this.deliveryInfo=new ArrayList<Delivery> ();
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
		this.address = new ArrayList<String>();
		this.contacter_names=new ArrayList<String>();
		this.fidelityCard = new BasicFidelityCard();
		this.deliveryInfo=new ArrayList<Delivery> ();
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
		this.address = new ArrayList<String>();
		this.contacter_names=new ArrayList<String>();
		contacter_names.add(last_name+" "+first_name);
//		this.login = new LoginClient();
//		this.register = new RegisterClient();
		this.fidelityCard = new BasicFidelityCard();
		this.deliveryInfo=new ArrayList<Delivery> ();
		
	}
	
	/**
	 * 
	 * @param user_name
	 * @param password
	 * @param birthday
	 */
	public Client(String user_name, String password, String birthday) {
		super();
		this.user_name = user_name;
		this.password = password;
		this.birthday = birthday;
		this.email = new ArrayList<String>();
		this.phone_number = new ArrayList<String>();
		this.address = new ArrayList<String>();
<<<<<<< HEAD
		this.authorization=true;

=======
		this.login = new LoginClient();
		this.register = new RegisterClient();
>>>>>>> 64b066b74918337b65dc7a82db04b4322fbd28d3
		this.fidelityCard = new BasicFidelityCard();
		this.deliveryInfo=new ArrayList<Delivery> ();
	}
	
	/**
	 * 
	 * @param fidelityCard
	 */
	public Client(FidelityCardVisitor fidelityCard){
		super();
		this.fidelityCard = fidelityCard;
<<<<<<< HEAD
		this.authorization=true;

	}
	

	public void add_contactInfo(String contactname, String phonenumber, String adress){
		Delivery new_deliveryInfo=new Delivery(contactname, phonenumber, adress);
		this.deliveryInfo.add(new_deliveryInfo);
		this.contacter_names.add(new_deliveryInfo.getContactname());
		this.address.add(new_deliveryInfo.getAdress());
		this.phone_number.add(new_deliveryInfo.getPhonenumber());
	}

=======
		this.login = new LoginClient();
		this.register = new RegisterClient();
	}
	
	
	
>>>>>>> 64b066b74918337b65dc7a82db04b4322fbd28d3
	
	
	public void addPoint(int points){
		this.fidelityCard.point += points;		
	}
	
	public void removePoint(int points){
		this.fidelityCard.point -= points;		
	}
	
	public void setPoint(int points){
		this.fidelityCard.point = points;
	}
	
	public void associateCard (FidelityCardVisitor cardType){
		this.fidelityCard=cardType;
	}
	
	public void add_email(String new_email){
		if(this.getAddress().contains(new_email))
			return;
		this.email.add(new_email);	
	}
	
	public void add_phone_number(String new_phone_number){
		if(this.getPhone_number().contains(new_phone_number))
			return;
		this.phone_number.add(new_phone_number);
	}
	
	public void add_address(String new_address){
		if(this.getAddress().contains(new_address))
			return;
		this.address.add(new_address);
	}
	
	public void add_favorite_meal(Meal meal){
		if(this.favorite_meals.contains(meal)){
			System.out.println("this meal already in your favorite list");
			return;
		}
		this.favorite_meals.add(meal);
	}
	
	public void add_contactname(String contactName){
		if (this.getContacter_names().contains(contactName))
			return;
		this.contacter_names.add(contactName);
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
	public ArrayList<String> getAddress() {
		return address;
	}
	public void setAddress(ArrayList<String> address) {
		this.address = address;
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

	public ArrayList<Delivery> getDeliveryInfo() {
		return deliveryInfo;
	}

	public void setDeliveryInfo(ArrayList<Delivery> deliveryInfo) {
		this.deliveryInfo = deliveryInfo;
	}



	



	


	
	
}
