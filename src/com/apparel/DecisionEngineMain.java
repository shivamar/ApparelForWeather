package com.apparel;

import com.apparel.service.DecisionEngine;

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