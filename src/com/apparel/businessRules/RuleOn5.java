package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn5 implements IRule {
	private static final String sAction_Cold = "jacket";
	private static String sCommand = "5";
	private static final String sDesc = "Put on jacket";
	private static final String sFail = "fail";
		
	@Override
	public String executeRule(ApparelWeatherInformation model) throws Exception {		
		if(model.getCurrWeather().equals(Weather.HOT))			
			return sFail;
		if(!checkIfShirtIsWorn(model))
			return sFail;
		
		 return sAction_Cold;
	}
	
	//checks if shirt is worn
	private boolean checkIfShirtIsWorn(ApparelWeatherInformation model) {
		return model.getApparelWorn(3);				
	}
}
