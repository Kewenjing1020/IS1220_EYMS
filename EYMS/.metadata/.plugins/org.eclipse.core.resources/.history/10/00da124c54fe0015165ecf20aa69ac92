package FidelityCard;

import Restaurant.Meal;

public class BasicFidelityCard extends FidelityCardVisitor{


	/**
	 * 
	 */
	private static final long serialVersionUID = -8902126880317952851L;

	@Override
	public String toString() {
		return "BasicFidelityCard";
	}

	@Override
	public Double getPriceVisit(Meal meal) {
		Double price = meal.getPrice();
		/**
		 * A client with a basic fidelity card can have access to special offer
		 */
		if (meal.getSpecial_price() != -1)
			price = meal.getSpecial_price();
		return price;
	}
	
	
	

}
