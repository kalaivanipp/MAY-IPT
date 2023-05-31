package com.TestNG;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners1 implements ITestListener{
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("On Test Start");
		System.out.println("Test Name:"+ result.getTestName());
		System.out.println("Name:"+ result.getName());
		System.out.println("Status:"+ result.getStatus());
	}
	
	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("On Test Success");
		System.out.println("Test Name:"+ result.getTestName());
		System.out.println("Name:"+ result.getName());
		System.out.println("Status:"+ result.getStatus());
	}
	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("On Test Failure");
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("On Test Skipped");
	}

}
