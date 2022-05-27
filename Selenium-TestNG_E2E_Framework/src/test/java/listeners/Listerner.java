package listeners;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;


import resources.BaseClass;
import resources.ExtentReportUtils;
import resources.ScreenshotUtils;

public class Listerner extends BaseClass implements ITestListener{

	
	
@Override		
    public void onTestStart(ITestResult result) 
	{					
    	testcasename= result.getMethod().getMethodName();
		
		System.out.println(testcasename + " Execution has started");
		
		test = extent.createTest(testcasename);
    }		
	

    @Override		
    public void onTestSuccess(ITestResult result) 
    {					
        			
    	testcasename= result.getMethod().getMethodName();
		System.out.println(testcasename + " Execution is successful");
		
		
		
		
		// giving the knowledge of the driver and to which test case the driver has to refer to during success
		try {
				driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
			} 
			catch (Exception e) {
			}
			
		
//		Taking screen capture on success
		try 
		{
			testcasename = result.getMethod().getMethodName();
			ScreenshotUtils.takescreenshot(driver, testcasename);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		try 
		{
			test.addScreenCaptureFromPath(ScreenshotUtils.takescreenshot(driver, testcasename), result.getMethod().getMethodName());
		} 
		catch (IOException e1) 
		{
			
			e1.printStackTrace();
		}
		
		
    }
	
    @Override		
    public void onTestFailure(ITestResult result) 
    {					
      			
    	testcasename= result.getMethod().getMethodName();
		
		System.out.println(testcasename + " Execution has failed");
		
		test.fail(result.getThrowable());
		
		
		// giving the knowledge of the driver and to which test case the driver has to refer to during failure
		try 
		{
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e) 
		{
			
			
		} 
    
		
//		Taking screen capture on failure
		try 
		{
			testcasename = result.getMethod().getMethodName();
			ScreenshotUtils.takescreenshot(driver, testcasename);
		} 
		catch (Exception e) 
		{
			
			e.printStackTrace();
		}
		try 
		{
			test.addScreenCaptureFromPath(ScreenshotUtils.takescreenshot(driver, testcasename), result.getMethod().getMethodName());
		} 
		catch (IOException e1) 
		{
			
			e1.printStackTrace();
		}
		
		
    }
    

    @Override		
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {					
       			
        		
    }		

   		

    @Override		
    public void onTestSkipped(ITestResult result) {					
        			
        		
    }		

    		
    	
    @Override		
    public void onFinish(ITestContext result) {					
        			
     extent.flush();
    }		

    @Override		
    public void onStart(ITestContext result) {					
    	
    }
}		

