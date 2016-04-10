package Part1;

import java.io.Serializable;
import java.util.Arrays;

import Restaurant.Order;
import User.Client;

/**
 * 
 * @author kewenjing
 *
 */
public class Delivery implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String contactname;
	private String phonenumber;
	private String adress;
//	private String[] delivery_info;
	/**
	 * @param order
	 * @param client
	 * @param contactname
	 * @param phonenumber
	 * @param adress
	 * @param delivery_info
	 */
	public Delivery( String contactname, String phonenumber, String adress) {
		super();
		this.contactname = contactname;
		this.phonenumber = phonenumber;
		this.adress = adress;
	}
	
	
	
	@Override
	public String toString() {
		return "Delivery [contactname=" + contactname + ", phonenumber=" + phonenumber + ", adress=" + adress + "]";
	}



	public String getContactname() {
		return contactname;
	}
	public void setContactname(String contactname) {
		this.contactname = contactname;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	
	
	
	
}
