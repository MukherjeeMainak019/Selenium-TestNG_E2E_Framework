package testcases;

import java.time.Duration;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import resources.BaseClass;

public class OrangeHRM_Sprint2 extends BaseClass {
	
	
	@Test
	public void validate_employee_added_successfully_by_readingconfigfile()
	{
		pimpage.PIM.click();
		
		Actions action = new Actions(driver);
		action.moveToElement(pimpage.PIM).clickAndHold().build().perform();
		
		pimpage.add_Employee.click();
		
		String expected_fullName = dataconfigproperties.getProperty("FullName");
		String expected_lastName = dataconfigproperties.getProperty("LastName");
		
		pimpage.first_Name.sendKeys(expected_fullName);
		pimpage.last_Name.sendKeys(expected_lastName);
		
		String empID = pimpage.employee_ID.getAttribute("value");
		
		pimpage.save_Button.click();
		
		
		action.release(pimpage.PIM);
		
		action.moveToElement(pimpage.PIM).clickAndHold().build().perform();
		
		pimpage.employee_List.click();
		
		pimpage.employee_ID_Search.sendKeys(empID);
		pimpage.search_Button.click();
		
		
		String actual_fullName = pimpage.first_And_Middle_Name_Searched.getText().trim();
		String actual_lastName = pimpage.last_Name_Searched.getText().trim();
		
		Assert.assertEquals(actual_fullName, expected_fullName);
		Assert.assertEquals(expected_lastName, actual_lastName);
		
		
	}



	

}