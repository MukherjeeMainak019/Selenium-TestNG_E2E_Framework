package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtils extends BaseClass{
	
	public static ExtentReports reportobject()
	{
		extentreport_Path = projectPath +"/report/report.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(extentreport_Path);
		reporter.config().setReportName("Selenium-TestNG-E2E_Framework");
		reporter.config().setDocumentTitle("OrangeHRM Eecution");
		
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo(" Automation Tester", "Selenium-TestNG-E2E");
		return extent;
		

}

}
