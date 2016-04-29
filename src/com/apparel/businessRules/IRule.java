package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;

public interface IRule {	
	public String executeRule(ApparelWeatherInformation app) throws Exception;	

}
