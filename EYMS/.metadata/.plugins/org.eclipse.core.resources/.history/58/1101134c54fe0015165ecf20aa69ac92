package FidelityCard;

import Restaurant.Meal;

public class LotteryFidelityCard extends FidelityCardVisitor{


	/**
	 * 
	 */
	private static final long serialVersionUID = -152178044169108710L;

	@Override
	public String toString() {
		return "LotteryFidelityCard";
	}
	
	@Override
	public Double getPriceVisit(Meal meal) {
		Double price = meal.getPrice();
		/*
		 * A client with a lottery fidelity card 
		 * can gain his meal for free each day
		 */
		if (Math.random() < 0.05)
			price = (double) 0;
		return price;
	}

}
