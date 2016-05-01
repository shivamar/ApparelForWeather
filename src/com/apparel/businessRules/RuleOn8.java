package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;

public class RuleOn8 implements IRule {
	private static final String sAction = "Removing PJs";
	private static String sCommand = "8";
	private static final String sDesc = "Take off Pajamas";
	private static final String sFail = "fail";

	/**
	 * Checks if the apparel had already been taken off
	 *  
	 */
	public String executeRule(ApparelWeatherInformation model) {	
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;
		
		model.setApparelWorn(7, true);
		return sAction;
	}
	
	

}
