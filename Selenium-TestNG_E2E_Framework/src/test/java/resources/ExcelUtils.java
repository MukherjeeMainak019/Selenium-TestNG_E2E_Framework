package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils extends BaseClass{


	public static  String excel_path = projectPath+"/Excel_Data/Test Data.xlsx";
	public static String Login_Data_sheetName ="Login Data";
	public static String Add_Employee_sheetName = "Add Employee Data";
	
	public static String userName;
	public static String password;
	public static String FirstName;
	public static String MiddleName;
	public static String LastName;
	public static int read_add_employee_data_total_row_count;
	public static int read_add_employee_data_total_row_count_row;
	

	public ExcelUtils(String excel_path)
	{
		this.excel_path =excel_path;


	}

	public static int getRowCount(String sheetName) throws IOException 
	{
		fi=new FileInputStream(excel_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowcount;		
	}


	public static int getCellCount(String sheetName,int rownum) throws IOException
	{
		fi=new FileInputStream(excel_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellcount;
	}


	public static String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(excel_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);

		DataFormatter formatter = new DataFormatter();
		String data;
		try{
			data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}

	public static void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(excel_path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			workbook=new XSSFWorkbook();
			fo=new FileOutputStream(excel_path);
			workbook.write(fo);
		}

		fi=new FileInputStream(excel_path);
		workbook=new XSSFWorkbook(fi);

		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);

		sheet=workbook.getSheet(sheetName);

		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
			sheet.createRow(rownum);
		row=sheet.getRow(rownum);

		cell=row.createCell(colnum);

		cell.setCellValue(data);

		fo=new FileOutputStream(excel_path);
		workbook.write(fo);		
		workbook.close();
		fi.close();
		fo.close();
	}



	public static void read_login_data() throws IOException
	{

		int total_row_count = getRowCount(Login_Data_sheetName);
		int start_rownum = 1;

		for(int i= start_rownum; i<=total_row_count; i++)
		{
			int rownum = i;
			userName = getCellData(Login_Data_sheetName, rownum, 0);
			password = getCellData(Login_Data_sheetName, rownum, 1);
		}


	}

	public static void write_back_logindata_valid_invalid(String data) throws IOException
	{
		int row = 1;
		int col = 2;
		setCellData(Login_Data_sheetName, row, col, data);
	}

	
	
}






