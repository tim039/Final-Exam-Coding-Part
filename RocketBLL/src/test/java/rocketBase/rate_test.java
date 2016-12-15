package rocketBase;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import exceptions.RateException;

public class rate_test {

	
	//		Check to see if a known credit score returns a known interest rate
	
	
		
	@Test
	public void getrate1() throws RateException {
		assertEquals(RateBLL.getRate(600),5,1);
	}
	
	@Test (expected = RateException.class)
	public void getRateException1() throws RateException {
		RateBLL.getRate(200);
	}
	
	@Test
	public void getPayment1() {
		assertEquals(RateBLL.getPayment(0.04/12,360,300000,0,false),1432.25,0.1);
	}

}
