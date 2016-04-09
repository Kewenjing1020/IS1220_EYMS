package Restaurant;

import java.io.Serializable;

import FidelityCard.FidelityCardVisitor;
import Operation.Visitable;

/**
 * 
 * @author kewenjing
 *
 */
public class Meal implements Serializable, Visitable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String dish_name;
	private String ingredient_detail;
	private Double price;
	private Double special_price;
	
	
	
	
	
	public Double getSpecial_price() {
		return special_price;
	}
	

	@Override
	public String toString() {
		return "Meal:" + dish_name + ", ingredient_detail=" + ingredient_detail + ", price=" + price
				+ ", special_price=" + special_price + ", stock=" + stock + ", quantity need for client=" + quantity + "\n";
	}



	public void setSpecial_price(Double special_price) {
		this.special_price = special_price;
	}
	
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	protected Integer stock;
	protected Integer quantity;
	/**
	 * @param dish_name
	 * @param ingredient_detail
	 */
	public Meal() {
		super();
		this.price=(double) 0;
		this.quantity = 1;
		this.special_price=(double) -1;
	}	
	
	
	
	/**
	 * @param dish_name
	 * @param ingredient_detail
	 * @param price
	 * @param stock
	 * @param quantity
	 */
	public Meal(String dish_name, String ingredient_detail, Double price) {
		super();
		this.dish_name = dish_name;
		this.ingredient_detail = ingredient_detail;
		this.price = price;
		this.quantity = 1;
		this.special_price=(double) -1;
	}
	
	public Meal(String dish_name) {
		// TODO Auto-generated constructor stub
		super();
		this.dish_name = dish_name;
		this.quantity = 1;
		this.special_price=(double) -1;
	}





//	public void add_to_cart(int qty){
//		this.quantity=qty;
//	}
	
	

	//getter and setter
	public String getDish_name() {
		return dish_name;
	}
	public void setDish_name(String dish_name) {
		this.dish_name = dish_name;
	}
	public String getIngredient_detail() {
		return ingredient_detail;
	}
	public void setIngredient_detail(String ingredient_detail) {
		this.ingredient_detail = ingredient_detail;
	}
	public Double getPrice() {
		if(this.special_price!=-1)
			return special_price;
		else
			return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getQuantity() {
		return quantity;
	}
//	public void setQuantity(Integer quantity) {
//		this.quantity = quantity;
//	}


	@Override
	public void getPriceAccept(FidelityCardVisitor visitor) {
		visitor.getPriceVisit(this);
		
	}
	

}
