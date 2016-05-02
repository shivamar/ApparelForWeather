package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;
import com.apparel.utility.InvalidCommandException;

public class RuleOn7 implements IRule{
	private static final String sAction = "leaving house";
	private static String sCommand = "7";
	private static final String sDesc = "Leave House";

	/**
	 * Checks if command had already been executed
	 * 
	 * You cannot leave the house until all the apparel had been completed
	 * @throws Exception 
	 */
	public String executeRule(ApparelWeatherInformation model) throws Exception {
		//only one piece of each type can be worn
		if(model.getApparelWorn(Integer.parseInt(sCommand)-1) == true) return sFail;					
				
		boolean[] apparelHistory = model.getApparelWorn();
		
		if(!checkWetherAllApparelAreWorn(apparelHistory, model.getCurrWeather())){
			return sFail;
		}
		
		model.setApparelWorn(6, true);
		return sAction;
	}

	/**
	 * Checks if all apparel are worn before leaving house
	 * @param apparelHistory
	 * @param currWeather
	 * @return
	 * @throws Exception
	 */
	private boolean checkWetherAllApparelAreWorn(boolean[] apparelHistory, Weather currWeather) throws Exception {
		int currCommand = Integer.parseInt(sCommand);
		
		if(Weather.COLD.equals(currWeather)){
			
			for(int i=0;i<apparelHistory.length;i++)
			{
				if(i != currCommand-1
				   && apparelHistory[i] != true){
					return false;
				}
			}
		}
		else if(Weather.HOT.equals(currWeather)){
			
			for(int i=0;i<apparelHistory.length;i++)
			{
				if(i != 2
				   && i != 4 
				   && i != (currCommand -1)
				   && apparelHistory[i] != true){
					return false;
				}
			}			
		}
		
		return true;
	}

}
