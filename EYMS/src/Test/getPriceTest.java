package Test;

import static org.junit.Assert.*;  


import org.junit.Before;
import org.junit.Test;

import FidelityCard.LotteryFidelityCard;
import FidelityCard.PointFidelityCard;
import Restaurant.Meal;
import User.Client;

/**
 * 
 * @author Lucas
 *
 */

public class getPriceTest {

	Client clientBasic = new Client();
	Client clientPoint = new Client(new PointFidelityCard());
	Client clientLottery = new Client(new LotteryFidelityCard());
	Meal potatoes = new Meal();
	
	
	@Before
	public void setUp() throws Exception {
		//initialization of the instance by default
		clientPoint.setPoint(0);
		potatoes.setPrice((double) 100);
		potatoes.setSpecial_price((double)-1);
	}
	
	
	@Test
	public void priceBasicFidelityCardWithoutSpecialPriceTest() {
		assertTrue("Basic fidelity card without special price",clientBasic.getPrice(potatoes)==(double) 100);	
		}
	
	@Test
	public void priceBasicFidelityCardWithSpecialPriceTest(){
		potatoes.setSpecial_price((double) 50);
		assertTrue("Basic fidelity card with special price",clientBasic.getPrice(potatoes)==(double) 50);
	}
	
	@Test
	public void pricePointFidelityCardWithLessThanOneHundredPointsTest(){
		assertTrue("Point fidelity card with less than 100 points", clientPoint.getPrice(potatoes)==(double)100);
	}
	
	@Test
	public void pricePointFidelityCardWithMoreThanOneHundredPointsTest(){
		
		clientPoint.setPoint(100);
		assertTrue("Point fidelity card with more than 100 points", clientPoint.getPrice(potatoes)==(double)90);
	}
	
	@Test
	public void priceLotteryFidelityCardTest(){
		assertTrue("Lottery fidelity card", clientLottery.getPrice(potatoes) == (double) 100 
				|| clientLottery.getPrice(potatoes) == (double) 0);
	}

}
