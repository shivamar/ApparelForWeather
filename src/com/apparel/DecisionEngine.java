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
		 String sResult = buildResultString(inputArgs);
		 print(sResult);
	}
	
	private static String buildResultString(String[] inputArgs) {
		int counter = 0;
		Weather currWeather;
		inputArgs[0] = sanitiseString(inputArgs[0]);
		if ("COLD".equals(inputArgs[0])) {
			currWeather = Weather.COLD;
		} else if ("HOT".equals(inputArgs[0])) {
			currWeather = Weather.HOT;
		} else {
			return "fail";
		}

		ApparelWeatherInformation apparelInfo = new ApparelWeatherInformation(
				currWeather, 8);

		String response;
		StringBuilder strB = new StringBuilder();
		RulesProcessor rulesProcessor = RulesProcessor.getInstance();

		for (int i = 1; i < inputArgs.length; i++) {
			inputArgs[i] = sanitiseString(inputArgs[i]);

			// initial state should always be removing pajamas
			if (i == 1 && !"8".equals(inputArgs[i])) {
				strB.append("fails");
				break;
			}
			response = rulesProcessor.processRule(apparelInfo, inputArgs[i]);
			if ("fails".equals(response)) {
				strB.append(response);
				break;
			}
			strB.append(response);
			if (i != inputArgs.length - 1) {
				strB.append(",");
			}
		}

		return strB.toString();
	}
	
	private static String sanitiseString(String string) {
		if(string != null){
			string = string.replace(',','\0');
			string = string.trim();			
		}
		return string;
	}

	private static void print(String msg) {
		System.out.println(msg);
	}
}