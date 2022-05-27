package resources;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageobjects.DashboardPage;
import pageobjects.LoginPanelPage;
import pageobjects.PIMPage;

public class BaseClass {

	public static WebDriver driver;
	public static String URL;
	public static String browserName;
	public static String projectPath = System.getProperty("user.dir");
	public static String screen_CapturePath;
	public static String testcasename = null;
	public static String extentreport_Path;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style; 
	
	
	public static Properties systemconfigproperties; 
	public static Properties dataconfigproperties;
	
	
	public static LoginPanelPage loginpanelpage;
	public static DashboardPage dashboardpage;
	public static PIMPage pimpage;
	
	
	@BeforeSuite
	public void read_Config_properties() throws IOException
	{
		PropertyUtils.read_system_config_properties();
		PropertyUtils.read_data_config_properties();
		
	}
	
	@BeforeTest
	public void init() throws IOException
	{
		extent = ExtentReportUtils.reportobject();
		ExcelUtils.read_login_data();
		
	}
	
	@BeforeMethod
	public void int_browser_and_launch_URL() throws IOException
	{
		browserName = systemconfigproperties.getProperty("Browser");
		URL = systemconfigproperties.getProperty("URL");
		
		switch(browserName) 
		{
		  case "Edge":
			  WebDriverManager.chromedriver().setup();
			  driver = new EdgeDriver();
			break;
			
		  case "Firefox":
			    WebDriverManager.chromedriver().setup();
				driver = new FirefoxDriver();
			break;
			
		  case "Safari":
			  	WebDriverManager.chromedriver().setup();
				driver = new SafariDriver();
			break;
			
		  default:
			  	WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		

		TestBaseUtils.pagefactoryinstances();
		login();
	}
	}
	
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	public static void login() throws IOException
	{
		String UserName = ExcelUtils.userName.trim();
		String Password = ExcelUtils.password.trim();
		loginpanelpage.Username.sendKeys(UserName);
		loginpanelpage.password.sendKeys(Password);
		loginpanelpage.login_button.click();
	}
}
