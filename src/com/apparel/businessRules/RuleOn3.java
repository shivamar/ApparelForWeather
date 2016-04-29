package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;

public class RuleOn3 implements IRule{
	private static final String sAction_Cold = "Sun Visor";
	private static String sCommand = "3";
	private static final String sDesc = "Put on socks";
	private static final String sFail = "fail";
	
	@Override
	/**
	 * if its hot, print fail else put on socks
	 */
	public String executeRule(ApparelWeatherInformation model) throws Exception {				
		
		if(model.getCurrWeather().equals(Weather.COLD))			
			return sAction_Cold;
		else 
			return sFail;
	}

}
