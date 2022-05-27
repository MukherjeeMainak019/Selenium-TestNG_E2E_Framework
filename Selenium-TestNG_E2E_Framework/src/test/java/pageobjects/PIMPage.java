package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PIMPage {
	
	public WebDriver driver;
	
	public PIMPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	
	@FindBy(id="menu_pim_viewPimModule")
	public WebElement PIM;
	
	@FindBy(id="menu_pim_addEmployee")
	public WebElement add_Employee;
	
	@FindBy (id = "firstName")
	public WebElement first_Name;
	
	@FindBy (id = "middleName")
	public WebElement middle_Name;
	
	@FindBy(id = "lastName")
	public WebElement last_Name;
	
	@FindBy(id="btnSave")
	public WebElement save_Button;
	
	@FindBy(id = "employeeId")
	public WebElement employee_ID;
	
	@FindBy(id = "menu_pim_viewEmployeeList")
	public WebElement employee_List;
	
	@FindBy (id = "empsearch_id")
	public WebElement employee_ID_Search;
	
	@FindBy (id = "searchBtn")
	public WebElement search_Button;
	
	@FindBy(xpath = "//div[@id='tableWrapper']//table//tbody//tr//td[3]")
	public WebElement first_And_Middle_Name_Searched;
	
	@FindBy(xpath = "//div[@id='tableWrapper']//table//tbody//tr//td[4]")
	public WebElement last_Name_Searched;
	
	
	
	
}
