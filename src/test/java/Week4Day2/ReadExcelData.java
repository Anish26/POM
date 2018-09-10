package Week4Day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public String[][] getData(String sheetName) throws IOException {
		//Open Workbook
		XSSFWorkbook wBook = new XSSFWorkbook("./data/"+sheetName+".xlsx");
		//Go to Sheet
		XSSFSheet sheet = wBook.getSheetAt(0);
//		Find the no of rows in the sheet
		int rowCount = sheet.getLastRowNum();
//		sheet.getPhysicalNumberOfRows();
		int columnCount = sheet.getRow(0).getLastCellNum();
//		to get the value and stored in 2D array String
		String[][] data = new String[rowCount][columnCount];
//		Go to row
		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
//		Go to cell
			for (int j = 0; j <columnCount ; j++) {
				XSSFCell cell = row.getCell(j);
//		Read the data & store the values in array
		data[i-1][j] = cell.getStringCellValue();
//				System.out.println(data);
				wBook.close();
			}
			
		}
		return data;
		
		

	}

}
