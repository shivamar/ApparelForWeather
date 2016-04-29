package com.apparel.businessRules;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;
import com.apparel.utility.InvalidCommandException;

public class RuleOn7 implements IRule{
	private static final String sAction = "leaving House";
	private static String sCommand = "7";
	private static final String sDesc = "Leave House";
	private static final String sFail = "fail";

	/**
	 * Checks if command had already been executed
	 * 
	 * You cannot leave the house until all the apparel had been completed
	 * @throws Exception 
	 */
	@Override
	public String executeRule(ApparelWeatherInformation model) throws Exception {
		boolean[] apparelHistory = model.getApparelWorn();
		
		if(!checkWetherAllApparelAreWorn(apparelHistory, model.getCurrWeather())){
			return sFail;
		}
		
		model.setApparelWorn(7, true);
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
				if(i != currCommand 
				   && apparelHistory[i] != true){
					return false;
				}
			}
		}
		else if(Weather.HOT.equals(currWeather)){
			
			for(int i=0;i<apparelHistory.length;i++)
			{
				if(i != 3
				   && i != 5 
				   && i != currCommand 
				   && apparelHistory[i] != true){
					return false;
				}
			}			
		}
		else{
			throw new InvalidCommandException();
		}
		
		return true;
	}

}
