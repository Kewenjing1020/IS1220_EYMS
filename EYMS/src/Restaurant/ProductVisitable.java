package Restaurant;

import FidelityCard.FidelityCardVisitor;

/**
 * Interface for the product the clients can buy
 * use in the visitor pattern to get theprice for a client depending
 * on his type of fidelity card
 * @author Lucas
 *
 */

public interface ProductVisitable {
	
	public int accept(FidelityCardVisitor visitor);
}
