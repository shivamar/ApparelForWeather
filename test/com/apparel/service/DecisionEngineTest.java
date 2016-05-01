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
	public void test() {
		String[] inputArgs={"HOT,", "8,", "6,", "4,", "2,", "1,", "7"};
		String expectedResult = "Removing PJs, shorts, t-shirt, sun visor, sandals, leaving house";
		String result = dsT.buildResultString(inputArgs);
		System.out.println(result);
		assertEquals(result, expectedResult);
	}

}
