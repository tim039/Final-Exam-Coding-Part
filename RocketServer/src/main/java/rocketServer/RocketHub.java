package rocketServer;

import java.io.IOException;

import exceptions.RateException;
import netgame.common.Hub;
import rocketBase.RateBLL;
import rocketData.LoanRequest;


public class RocketHub extends Hub {

	private RateBLL _RateBLL = new RateBLL();
	
	public RocketHub(int port) throws IOException {
		super(port);
	}

	@Override
	protected void messageReceived(int ClientID, Object message) {
		System.out.println("Message Received by Hub");
		
		if (message instanceof LoanRequest) {
			resetOutput();
			
			LoanRequest lq = (LoanRequest) message;
		

			//	You will have to:
			
			//	Determine the rate with the given credit score (call RateBLL.getRate)
			//		If exception, show error message, stop processing
			//		If no exception, continue
			
			double currentRate = 0.0;
			try {
				currentRate = rocketBase.RateBLL.getRate(lq.getiCreditScore());
			}
			
			catch (RateException e) {
				e.printStackTrace();
			}
			
//			Determine if payment, call RateBLL.getPayment
			
			finally {
				double pmt = _RateBLL.getPayment(currentRate, lq.getiTerm(),lq.getdAmount() - lq.getiDownPayment(), 0.0, false);
				lq.setdPayment(pmt);
						
			}
		
		//	
					//	you should update lq, and then send lq back to the caller(s)
			
			sendToAll(lq);
		}
	}
}
