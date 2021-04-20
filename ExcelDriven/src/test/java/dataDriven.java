import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriven {
	
	public static void main(String[] args) throws IOException {
		
	// Create object FileInputStream to access the location of workbook
	FileInputStream fis = new FileInputStream("C:\\Royal\\DemoData.xlsx");
	
	//Create Object for XSSSFWorkbook to access the workbook
	XSSFWorkbook workbook = new XSSFWorkbook(fis);
	
	//first get the count of sheets and iterate to reach the specific sheet
	int sheets = workbook.getNumberOfSheets();
	for(int i =0;i<sheets;i++)
	{
		if(workbook.getSheetName(i).equalsIgnoreCase("Scenario1"))
		{
			XSSFSheet sheet = workbook.getSheetAt(i);
			
			//Identify 'TestCase' coloum by scanning the entire 1st row
			Iterator<Row> rows = sheet.iterator();//sheet is a collection of rows
			Row firstRow = rows.next();
			
			Iterator<Cell> ce = firstRow.cellIterator();//rows is a collection of cells
			
			int k = 0;
			int column = 0;
			while(ce.hasNext())
			{
				Cell value = ce.next();
				if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
				{
					column = k;
				}
				k++;
			}
			System.out.println(column);
			
		//Once coloumn is identified then scan entire testcase coloum to identify 'Login' testcase row
			
			while(rows.hasNext())
			{
				Row r = rows.next();
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Login"))
				{
					//After you grab Login testcase row = pull all the data of that row and feed into test
					Iterator<Cell> cv = r.cellIterator();
					while(cv.hasNext())
					{
						Cell c = cv.next();
						if(c.getCellType()==CellType.STRING)
						{
							System.out.println(c.getStringCellValue());
						}
					}
				}
			}
			
		}
	}

	
	
	
	
	}
	
}
