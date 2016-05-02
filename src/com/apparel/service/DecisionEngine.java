package com.apparel.service;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;
import com.apparel.utility.InvalidCommandException;

public class DecisionEngine {
	private static final String sFail="fail";
	private ApparelWeatherInformation apparelInfo;
	private RulesProcessor rulesProcessor = RulesProcessor.getInstance();
	/**
	 * Parses the input and calls ResultProcessor to build the result
	 * @param inputArgs input argument string
	 * @return result string
	 */
	public String buildResultString(String[] inputArgs) {		
		Weather currWeather;
		StringBuilder strB = new StringBuilder();
		String response;	
		try{
			currWeather = setCurrWeather(sanitiseString(inputArgs[0]));
			apparelInfo = setApparel(apparelInfo, currWeather);		
				
			for (int i = 1; i < inputArgs.length; i++) {
				inputArgs[i] = sanitiseString(inputArgs[i]);
				if (i == 1 && !"8".equals(inputArgs[i])) { 
					strB.append("fail"); 				// initial state should always be removing pajamas
					break;
				}
				response = rulesProcessor.processRule(apparelInfo, inputArgs[i]);
				
				if ("fail".equals(response)) {
					strB.append(response);
					break;
				}
				strB.append(response);
				
				if (i != inputArgs.length - 1) {
					strB.append(", ");
				}
			}
	
			return strB.toString();
		}
		catch(Exception e)
		{
			return sFail;
		}
	}
	
	private Weather setCurrWeather(String sWeather) throws InvalidCommandException
	{
		if ("COLD".equals(sWeather)) {
			return Weather.COLD;
		} else if ("HOT".equals(sWeather)) {
			return Weather.HOT;
		} else {
			throw new InvalidCommandException();			
		}	
	}
	
	private ApparelWeatherInformation setApparel(ApparelWeatherInformation apparelWeatherInfo, Weather currWeather)
	{
		apparelWeatherInfo = new ApparelWeatherInformation(currWeather, 8);
		return apparelWeatherInfo;
	}
	
	/**
	 * Removes , and trims strings
	 * @param string
	 * @return string
	 */
	private static String sanitiseString(String sInput) {
		if(sInput != null){
			sInput = (sInput.replace(',','\0')).trim();				
		}
		return sInput;
	}
}
