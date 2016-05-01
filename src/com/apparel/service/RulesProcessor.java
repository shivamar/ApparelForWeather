package com.apparel.service;

import java.util.ArrayList;
import java.util.HashMap;

import com.apparel.businessRules.IRule;
import com.apparel.businessRules.RuleOn1;
import com.apparel.businessRules.RuleOn2;
import com.apparel.businessRules.RuleOn3;
import com.apparel.businessRules.RuleOn4;
import com.apparel.businessRules.RuleOn5;
import com.apparel.businessRules.RuleOn6;
import com.apparel.businessRules.RuleOn7;
import com.apparel.businessRules.RuleOn8;
import com.apparel.model.ApparelWeatherInformation;

/**
 * A singleton Class mapping the rules with apparels
 * It provides a method processRules 
 * which calls the respective Rule 
 * depending upon the input command
 * @author Shiva
 *
 */
public class RulesProcessor {	
	private HashMap<String, IRule> rulesMap;
	private static RulesProcessor rProc;
	
	private RulesProcessor(){
		rulesMap = new HashMap<>();
		populateMap();
	}
	
	public static RulesProcessor getInstance(){
		if(rProc == null){
			rProc = new RulesProcessor();
		}
		
		return rProc;
	}
	
	private void populateMap() {
		rulesMap.put("8",new RuleOn8());
		rulesMap.put("7",new RuleOn7());
		rulesMap.put("6",new RuleOn6());
		rulesMap.put("5",new RuleOn5());
		rulesMap.put("4",new RuleOn4());
		rulesMap.put("3",new RuleOn3());
		rulesMap.put("2",new RuleOn2());
		rulesMap.put("1",new RuleOn1());
	}	
	
	public String processRule(ApparelWeatherInformation app, String inputArgs) {				
		IRule irule = rulesMap.get(inputArgs);
		String  result;
		try {
			result = irule.executeRule(app);
		}
		catch(Exception e){
			result = "fail";
		}
		
		return result;
	}	
}