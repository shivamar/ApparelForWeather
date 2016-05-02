package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn4 implements IRule{
	private static final String sAction_Cold = "shirt";
	private static final String sAction_Hot = "t-shirt";
	private static String sCommand = "4";
	private static final String sDesc = "Put on shirt";
	
	public String executeRule(ApparelWeatherInformation model) throws Exception {				
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;
			
		model.setApparelWorn(3, true);
		if(model.getCurrWeather().equals(Weather.COLD))			
			return sAction_Cold;
		else 
			return sAction_Hot;
	}

}
