package resources;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtils extends BaseClass{

	
	public static String takescreenshot(WebDriver driver, String testcasename) throws IOException
	{
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		screen_CapturePath = projectPath+"/Screenshots/" +testcasename+ ".png";
		
		File dest = new File(screen_CapturePath);
		
		FileUtils.copyFile(src, dest);
		
		return screen_CapturePath;
		
		
	}
}
