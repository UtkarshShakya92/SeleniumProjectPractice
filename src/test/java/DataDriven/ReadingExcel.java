package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//File ---> Workbook ---> Sheet ---> Rows ---> Cell

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1"); //workbook.getSheetAt(0);--index
		
		int totalrows =sheet.getLastRowNum();
		int totalcells=sheet.getRow(1).getLastCellNum();
		
		System.out.println("total number of rows :"+totalrows); //5
		System.out.println("total number of cells :"+totalcells);//4
		
		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentRow =sheet.getRow(r);
			for(int c=0;c<totalcells;c++)
			{
			      XSSFCell cell= currentRow.getCell(c);	
			      
			      String value = cell.toString();
			      System.out.print(value+"      ");
			}
			
			System.out.println();
		}
           workbook.close();
           file.close();
	}
         
}
