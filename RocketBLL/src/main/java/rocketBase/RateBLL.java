package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.FinanceLib;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException
	{
		
		
		

		ArrayList<RateDomainModel> alRates = _RateDAL.getAllRates();
	
		double rate1 = 0.0;
			for (RateDomainModel r : alRates) {
				if (GivenCreditScore >= r.getiMinCreditScore()) {
					rate1 = r.getdInterestRate();
				}
			
			if (rate1 < 0.0) {
				throw new RateException(r);
			}
			}
				
		
		//			obviously this should be changed to return the determined rate
		return rate1;
		
	}
		
	
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return Math.abs(FinanceLib.pmt(r, n, p, f, t));
	}
	
}

