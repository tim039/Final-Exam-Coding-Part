package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	
	RateDomainModel rateDomainModel = new RateDomainModel();
	
	public RateException (RateDomainModel e) {
		this.rateDomainModel = e;
	}
	
	public RateDomainModel getrateDomainModel() {
		return rateDomainModel;
	}
}
