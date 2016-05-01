package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn1 implements IRule {
	private static final String sAction_Hot = "sandals";
	private static final String sAction_Cold = "boots";
	private static String sCommand = "1";
	private static final String sDesc = "Put on Footwear";
	private static final String sFail = "fail";
	
	public String executeRule(ApparelWeatherInformation model) throws Exception {						
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;
		
		///socks and pants must be worn;		
		if(!checkIfSocksAreWorn(model)){
			return sFail;
		}
		
		if(!checkIfPantsAreWornInColdWeather(model)){
			return sFail;
		}
		
		model.setApparelWorn(0, true);		
		if(model.getCurrWeather().equals(Weather.COLD))
			return sAction_Cold;
		else return sAction_Hot;
	}

	//check if pant is worn 
	private boolean checkIfPantsAreWornInColdWeather(ApparelWeatherInformation model) {
		if (model.getCurrWeather().equals(Weather.COLD)
				&& !model.getApparelWorn(5)) {
			return false;
		}
		return true;
	}
	
	//check if socks is worn when cold 
	private boolean checkIfSocksAreWorn(ApparelWeatherInformation model) {
		return model.getCurrWeather().equals(Weather.HOT)
				|| (model.getCurrWeather().equals(Weather.COLD) && model
						.getApparelWorn(2));				
	}
}
