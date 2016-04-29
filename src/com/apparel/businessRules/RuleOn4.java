package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn4 implements IRule{
	private static final String sAction_Cold = "shirt";
	private static final String sAction_Hot = "t-shirt";
	private static String sCommand = "4";
	private static final String sDesc = "Put on shirt";
	private static final String sFail = "fail";
	
	@Override	
	public String executeRule(ApparelWeatherInformation model) throws Exception {				
		
		if(model.getCurrWeather().equals(Weather.COLD))			
			return sAction_Cold;
		else 
			return sAction_Hot;
	}

}
