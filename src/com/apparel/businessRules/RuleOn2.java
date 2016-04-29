package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn2 implements IRule {
	private static final String sAction_Hot = "Hat";
	private static final String sAction_Cold = "Sun Visor";
	private static String sCommand = "2";
	private static final String sDesc = "Put on Headwear";
	private static final String sFail = "fail";
	
	@Override
	/**
	 * checks if shirt is on before headwear is worn
	 */
	public String executeRule(ApparelWeatherInformation model) throws Exception {
		
		if(!checkIfShirtIsWorn(model)){
			return sFail;
		}
		
		if(model.getCurrWeather().equals(Weather.COLD))			
			return sAction_Cold;
		else 
			return sAction_Hot;
	}

	//checks if shirt is worn when cold
	private boolean checkIfShirtIsWorn(ApparelWeatherInformation model) {
		return model.getCurrWeather().equals(Weather.HOT)
				|| (model.getCurrWeather().equals(Weather.COLD) && model
						.getApparelWorn(3));				
	}
	

}
