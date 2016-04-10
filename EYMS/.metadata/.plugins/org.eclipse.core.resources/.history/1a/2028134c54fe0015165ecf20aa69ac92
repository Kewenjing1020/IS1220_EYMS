package FidelityCard;

import Restaurant.Meal;

public class PointFidelityCard extends FidelityCardVisitor{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public String toString() {
		return "PointFidelityCard [point=" + point + "]";
	}

	@Override
	public Double getPriceVisit(Meal meal) {
		Double price = meal.getPrice();
		/**
		 * A client with a point fidelity card 
		 * can have access a reduction of 10%
		 * if they have enough points
		 */
		if (this.point >= 100)
			price *= 0.9;
		return price;
	}

}
