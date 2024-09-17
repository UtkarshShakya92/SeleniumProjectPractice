package testng;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnersMethods implements ITestListener{

	public void onTestStart(ITestResult result)
	{
		System.out.println("On test start ...");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		System.out.println("On test success ...");
	}
	
	public void onTestFailure(ITestResult result)
	{
		System.out.println("On test Failure ...");
	}
	
	public void onTestSkipped(ITestResult result)
	{
		System.out.println("On test Skipped ...");
	}
	
	public void onTestFinish(ITestContext context)
	{
		System.out.println("On test finish ...");
	}
}

/*
 * <listeners>  
		
		<listener class-name="testng.ListnersMethods"></listener>
		
	</listeners>*/
