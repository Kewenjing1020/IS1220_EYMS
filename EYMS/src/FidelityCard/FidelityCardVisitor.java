package FidelityCard;

import java.io.Serializable;
import Restaurant.Meal;

/**
 * Abstract class for fidelity cards
 * We adapt the Visitor pattern using an abstract class
 * instead of an interface
 * @author Lucas
 *
 */

public abstract class FidelityCardVisitor implements Serializable {
	
	
	private static final long serialVersionUID = -8410502348215707271L;
	
	public int point = 0;
	
	/**
	 * Abstract getPriceVisit method 
	 * use to get the price of a meal for a client 
	 * depending on his type of fidelity card
	 * @return
	 */
	public abstract Double getPriceVisit(Meal meal);

}
