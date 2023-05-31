package com.utilityTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestUtil {
	public static Object[][] getTestData() throws Exception {
		File f=new File("C:\\Users\\kalai\\Green Practice\\Adactin_Hotel_Mini\\src\\test\\ExcelTestNG\\DataProviderTestNG.xlsx");
		 FileInputStream fs=new FileInputStream(f); 
		 XSSFWorkbook wb=new XSSFWorkbook(fs);
		 
		 XSSFSheet sheet = wb.getSheet("sheet1");
		 int numberOfRows = sheet.getPhysicalNumberOfRows();
		 
		 System.out.println("Reading All Data from Excel Spread Sheet:");
		 Object[][] data= new Object[sheet.getPhysicalNumberOfRows()][sheet.getRow(0).getPhysicalNumberOfCells()];
		 for(int i=0;i<numberOfRows;i++){			 
			 XSSFRow row = sheet.getRow(i);
			 int numberOfCells = row.getPhysicalNumberOfCells();
			 for(int j=0;j<numberOfCells;j++) {
				 
			  XSSFCell cell = row.getCell(j);
			  CellType type = cell.getCellType();
			  
			  if(type.equals(CellType.STRING)) {
				 // String value = cell.getStringCellValue();
				  data[i][j]=cell.getStringCellValue();
				  System.out.println(data[i][j]);
			  }
			  else if(type.equals(CellType.NUMERIC)) {
				  //double value= cell.getNumericCellValue();
				  data[i][j]=cell.getStringCellValue();
				  System.out.println(data[i][j]);
			  }}}
		return data;
		
	}

}
