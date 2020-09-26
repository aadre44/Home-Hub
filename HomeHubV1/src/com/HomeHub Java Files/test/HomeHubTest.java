package com.HomeHubV1.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ HomeServiceTest.class })
public class HomeHubTest {

	public static void main(String[] args) {
		HomeServiceTest homeTest = new HomeServiceTest();
		homeTest.addTest();

	}

}
