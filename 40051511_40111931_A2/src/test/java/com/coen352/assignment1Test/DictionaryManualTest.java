package com.coen352.assignment1Test;

public class DictionaryManualTest {

		public static void main(String[] args) {
		   
			DictionaryManualTest.runManualTest();
		   
	   }
	   
	   public static void runManualTest() {
		   com.coen352.assignment1Test.DictionaryJUnitTest t = new com.coen352.assignment1Test.DictionaryJUnitTest();
		   com.coen352.assignment1Test.DictionaryJUnitTest.setUp();
		   t.testClear();
		   t.testFind();
		   t.testInsert();
		   t.testRemove();
		   t.testRemoveAny();
		   t.testSize();
	   }
	   
	
}