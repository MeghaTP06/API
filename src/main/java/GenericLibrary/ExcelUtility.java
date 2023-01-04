package GenericLibrary;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtility 
{
	public Object[][] readMultipleData(String SheetName) throws Throwable 
	{
		FileInputStream fi = new FileInputStream("./src/main/resources/DDproj.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet(SheetName);
		int lastrow = sh.getLastRowNum()+1;
		short lastcell=sh.getRow(0).getLastCellNum();
		
		Object[][] obj=new Object[lastrow][lastcell];
		for (int i = 0; i <lastrow; i++) 
		{
			for(int j=0;j<lastcell;j++)
			{
			obj[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
}
	public String readDataFromExcel(String SheetName, int RowNo, int ColumnNo) throws Throwable
	{
		FileInputStream fi = new FileInputStream(IPathConstant.ExcelPath);	
		Workbook wb = WorkbookFactory.create(fi);	
		Sheet sh = wb.getSheet(SheetName);			
		Row ro = sh.getRow(RowNo);						
		Cell cel = ro.getCell(ColumnNo);					
		String value = cel.getStringCellValue();
		return value;
	}
}
