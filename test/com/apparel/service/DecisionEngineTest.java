package com.apparel.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DecisionEngineTest {

	DecisionEngine dsT;
	@Before
	public void setUp() throws Exception {
		dsT= new DecisionEngine();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCase1() {
		String[] inputArgs={"HOT", "8,", "6,", "4,", "2,", "1,", "7"};
		String expectedResult = "Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		//System.out.println(result);
  }
	
	@Test
	public void testCase2() {
		//COLD 8, 6, 3, 4, 2, 5, 1, 7		
		String[] inputArgs={"COLD", "8,", "6,", "3", "4", "2", "5", "1", "7"};
		String expectedResult = "Removing PJs, pants, socks, shirt, hat, jacket, boots, leaving house";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		System.out.println(result);
  }
	
	@Test
	public void testCase3() {
		String[] inputArgs={"HOT", "8,", "6,", "6"};
		String expectedResult = "Removing PJs, shorts, fail";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		//System.out.println(result);
  }
	
	@Test
	public void testCase4() {
		String[] inputArgs={"HOT,", "8,", "6,", "3"};
		String expectedResult = "Removing PJs, shorts, fail";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		//System.out.println(result);
  }
	
	@Test
	public void testCase5() { //COLD 8, 6, 3, 4, 2, 5, 7
		String[] inputArgs={"COLD,", "8,", "6,", "3,","4,", "2,", "5,", "7"};
		String expectedResult = "Removing PJs, pants, socks, shirt, hat, jacket, fail";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		System.out.println(result);
  }
	
	@Test
	public void testCase6() { //COLD 6
		String[] inputArgs={"COLD,", "6"};
		String expectedResult = "fail";
		String result = dsT.buildResultString(inputArgs);
		assertEquals(result, expectedResult);
		//System.out.println(result);
  }

}
