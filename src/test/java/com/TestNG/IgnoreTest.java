package com.TestNG;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class IgnoreTest {
	
	@Test(enabled=false)
	private void BrowserLaunch() {
		System.out.println("BrowserLaunch");
			}
@Test
private void getUrl() {
	System.out.println("getUrl");
}
@Test
private void dresses() {
	System.out.println("Dresses");
}
}
