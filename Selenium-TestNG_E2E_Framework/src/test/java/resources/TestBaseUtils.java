package resources;


import pageobjects.DashboardPage;
import pageobjects.LoginPanelPage;
import pageobjects.PIMPage;


public class TestBaseUtils extends BaseClass{
	
	
	public static void pagefactoryinstances()
	{
		loginpanelpage = new LoginPanelPage(driver);
		dashboardpage = new DashboardPage(driver);
		pimpage = new PIMPage(driver);
		
	}
}
