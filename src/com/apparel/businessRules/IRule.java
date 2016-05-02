package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;

public interface IRule {	
	public static final String sFail = "fail";
	public String executeRule(ApparelWeatherInformation app) throws Exception;	

}
