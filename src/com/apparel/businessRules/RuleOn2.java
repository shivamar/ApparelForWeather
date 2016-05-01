package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn2 implements IRule {
	private static final String sAction_Hot = "sun visor";
	private static final String sAction_Cold = "hat";
	private static String sCommand = "2";
	private static final String sDesc = "Put on Headwear";
	private static final String sFail = "fail";
	
	/**
	 * checks if shirt is on before headwear is worn
	 */
	public String executeRule(ApparelWeatherInformation model) throws Exception {
		
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;
		
		if(!checkIfShirtIsWorn(model)){
			return sFail;
		}
		
		model.setApparelWorn(1, true);	
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
