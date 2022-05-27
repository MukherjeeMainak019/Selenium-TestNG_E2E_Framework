package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {

public WebDriver driver;
	
	public DashboardPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	
	@FindBy(xpath = "//legend[contains (text(), 'Quick Launch')]")
	public WebElement quick_launch;
}
