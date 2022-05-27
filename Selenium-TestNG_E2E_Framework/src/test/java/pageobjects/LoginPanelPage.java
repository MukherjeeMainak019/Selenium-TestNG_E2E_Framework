package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import resources.BaseClass;

public class LoginPanelPage extends BaseClass {
	
	public WebDriver driver;
	
	public LoginPanelPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(id ="txtUsername")
	public WebElement Username;
	
	@FindBy(id ="txtPassword")
	public WebElement password;
	
	@FindBy(id ="btnLogin")
	public WebElement login_button;
}
