package testcases;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageobjects.LoginPanelPage;
import resources.BaseClass;
import resources.ExcelUtils;
import resources.ScreenshotUtils;

public class OrangeHRM_Sprint1 extends BaseClass{
	
	@Test
	public void to_validate_successful_login() throws IOException
	{
		String expected = dataconfigproperties.getProperty("Expected_text_in_currentURL_after_login").trim();
		String actual = driver.getCurrentUrl().trim();
		if(actual.contains(expected))
		{
			ExcelUtils.write_back_logindata_valid_invalid("Valid Login");
			Assert.assertTrue(true);
			
		}
		else
		{
			ExcelUtils.write_back_logindata_valid_invalid("Invalid Login");
			Assert.assertTrue(false, "Expected " + expected + " but found" + actual);
			
		}
	}
	@Test
	public void to_validate_dashboard_quicklaunch_text() throws IOException
	{
		String expected = dataconfigproperties.getProperty("Expected_text_under_dashboard").trim();
		String actual = dashboardpage.quick_launch.getText();
		Assert.assertEquals(actual, expected);
	}
}