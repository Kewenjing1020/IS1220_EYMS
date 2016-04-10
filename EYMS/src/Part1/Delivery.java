package Part1;

import java.util.Arrays;

import Restaurant.Order;
import User.Client;

/**
 * 
 * @author kewenjing
 *
 */
public class Delivery {

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
//		this.delivery_info = new String[3];
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
//	public String[] getDelivery_info() {
//		return delivery_info;
//	}
//	public void setDelivery_info(String[] delivery_info) {
//		this.delivery_info[0]=this.contactname ;
//		this.delivery_info[1]=this.phonenumber ;
//		this.delivery_info[2]=this.adress;
//	}
	
	
	
	
	
	
}
