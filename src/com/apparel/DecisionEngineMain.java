package com.apparel;

import com.apparel.model.ApparelWeatherInformation;
import com.apparel.model.Weather;
import com.apparel.service.DecisionEngine;
import com.apparel.service.RulesProcessor;

/**
 * Processes the input and prints the results
 * @author Shiva
 *
 */
public class DecisionEngineMain {

	public static void main(String[] inputArgs) {	
		try
		{
			DecisionEngine ds = new DecisionEngine();
            print(ds.buildResultString(inputArgs));
		}
		catch(Exception e)
		{
			print("fail");
		}
	}	

	private static void print(String msg) {
		System.out.println(msg);
	}
}