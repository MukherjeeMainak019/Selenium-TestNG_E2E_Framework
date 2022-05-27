package testcases;

import java.io.IOException;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import resources.BaseClass;
import resources.ExcelUtils;

public class OrangeHRM_Sprint3 extends BaseClass{


	@Test
	public void validate_employee_added_successfully_by_readingExcelfile() throws IOException
	{
		String FirstName;
		String MiddleName;
		String LastName;

		
		int total_row_count = ExcelUtils.getRowCount(ExcelUtils.Add_Employee_sheetName);
		int start_rownum = 1;

		for(int i= start_rownum; i<=total_row_count; i++)
		{
			int rownum = i;
			FirstName = ExcelUtils.getCellData(ExcelUtils.Add_Employee_sheetName, rownum, 0);
			MiddleName = ExcelUtils.getCellData(ExcelUtils.Add_Employee_sheetName, rownum, 1);
			LastName = ExcelUtils.getCellData(ExcelUtils.Add_Employee_sheetName, rownum, 2);
			
			pimpage.PIM.click();

			Actions action = new Actions(driver);
			action.moveToElement(pimpage.PIM).clickAndHold().build().perform();

			pimpage.add_Employee.click();

			pimpage.first_Name.sendKeys(FirstName.trim());
			pimpage.middle_Name.sendKeys(MiddleName.trim());
			pimpage.last_Name.sendKeys(LastName.trim());

			String empID = pimpage.employee_ID.getAttribute("value");
			
			ExcelUtils.setCellData(ExcelUtils.Add_Employee_sheetName, rownum, 3, empID);

			pimpage.save_Button.click();
			
		}
	}
	
}

