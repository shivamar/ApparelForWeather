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
		parseInput(inputArgs);
	}
	
	private static void parseInput(String[] inputArgs){
		int counter = 0;
		Weather currWeather;
		
		if(inputArgs[0].equals("COLD")){
			currWeather = Weather.COLD;
		}
		else if(inputArgs[0].equals("HOT")){
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
			if(i==1 && !"8".equals(inputArgs[i])){
					strB.append("fails");				
					break;
			}
			
			response = rProc.processRule(apparelInfo, inputArgs[i]);
			
			if("fails".equals(response)){
				strB.append(response);				
				break;
			}
			
			strB.append(response);
			
			if(i != inputArgs.length-1){
				strB.append(",");
			}			
		}
		
		print(strB.toString());	
		
	}
	
	private static void print(String msg) {
		System.out.println(msg);
	}
}