package week5.day4HomeAssignment;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExceldata {

	public static String[][] extractDataFromExcel(String fileName) throws IOException {
		//Step1-> Set path for workbook 
		XSSFWorkbook excel;
		excel=new XSSFWorkbook("./testleafdata/"+fileName+".xlsx");
		//step2-> Get into the sheet
		XSSFSheet sheet = excel.getSheet("sheet1");
		//Step3-> Get into Row values 
		int totalnoofRows = sheet.getLastRowNum();
		System.out.println("Total no of rows in the table: " +totalnoofRows);
		//Step4-> Get into cell values 
		short totalnocolumns = sheet.getRow(totalnoofRows).getLastCellNum();
		System.out.println("Total no of columns in the table: " +totalnocolumns);
		//Step5-> Read Data from workbook and print
		String[][] testrecord=new String[totalnoofRows][totalnocolumns];
		//Step5-> Read Data from workbook and print	
		for(int i=1;i<totalnoofRows;i++)
		{
			System.out.print("|");
			for(int j=0;j<totalnocolumns;j++)
			{
				String testData=sheet.getRow(i).getCell(j).getStringCellValue();
				testrecord[i-1][j]=testData;
				System.out.print("|"+testData);
			}
			System.out.println();
		}		 
		 //Step6-> close the workbook
		 excel.close();
		 return testrecord;
	}
}
