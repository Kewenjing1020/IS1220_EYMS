package Operation;

import FidelityCard.FidelityCardVisitor;

public interface Visitable {
	public abstract void getPriceAccept(FidelityCardVisitor visitor);
}
