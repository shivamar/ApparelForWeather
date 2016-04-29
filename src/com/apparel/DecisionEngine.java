package com.apparel;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;
import com.apparel.service.RulesProcessor;

/**
 * Processes the input and prints the results
 * @author Shiva
 *
 */
public class DecisionEngine {

	public static void main(String[] inputArgs) {
		int counter = 0;
		Weather currWeather;
		
		if(inputArgs[0] == "COLD"){
			currWeather = Weather.COLD;
		}
		else if(inputArgs[0] == "HOT"){
			currWeather = Weather.HOT;
		}
		else {
			print("fail");		
			return;
		}
		
		ApparelWeatherInformation apparelInfo = new ApparelWeatherInformation(currWeather,8);	
		
		String response;
		StringBuilder strB = new StringBuilder();
		RulesProcessor rProc = RulesProcessor.getInstance();
		
		for(int i=1; i < inputArgs.length; i++)
		{			
			//initial state should always be removing pajamas
			if(i==1 && inputArgs[i] != "8"){
					strB.append("fails");				
					break;
			}
			
			response = rProc.processRule(apparelInfo, inputArgs[i]);
			
			if("fails".equals(response)){
				strB.append(response);				
				break;
			}
			
			strB.append(response);
			
			if(i != inputArgs.length){
				strB.append(",");
			}			
		}
		
		print(strB.toString());		
	}
	
	private static void print(String msg) {
		System.out.println(msg);
	}
}