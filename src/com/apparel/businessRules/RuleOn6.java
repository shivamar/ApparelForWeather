package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn6 implements IRule {
	private static final String sAction_Hot = "shorts";
	private static final String sAction_Cold = "pants";
	private static String sCommand = "6";
	private static final String sDesc = "Put on pants";
	private static final String sFail = "fail";

	@Override
	/**
	 * 
	 */
	public String executeRule(ApparelWeatherInformation model) throws Exception {
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;
					
		model.setApparelWorn(5, true);
		if(model.getCurrWeather().equals(Weather.COLD))			
			return sAction_Cold;
		else 
			return sAction_Hot;
	}
}
