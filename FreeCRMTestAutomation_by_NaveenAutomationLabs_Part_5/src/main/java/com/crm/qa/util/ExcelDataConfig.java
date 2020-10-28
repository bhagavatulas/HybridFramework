package com.crm.qa.util;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataConfig {
	
	XSSFWorkbook wbx;
	XSSFSheet    sheet1;
	
	// Parametrized Constructor
	public ExcelDataConfig (String ExcelPath) {
		
		// Surround lines 20 thru 24 with try/catch block
		try {
			// File src = new File ("src/ExcelData/TestData.xlsx");
			File             src = new File (ExcelPath);
			FileInputStream  fis = new FileInputStream (src);
			wbx                  = new XSSFWorkbook(fis);     // For ".xlsx" file extension
			//sheet1             = wbx.getSheetAt(0);
		}

		// Ignore the 2 catch blocks added automatically
		/*
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		// Manually add the below catch block
		catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println (e.getMessage());
		}
	}
	
	public String getData (int sheetNumber, int row, int column) {
		sheet1      = wbx.getSheetAt(sheetNumber);
		String data = sheet1.getRow(row).getCell(column).getStringCellValue();
		return data;
	}
	
	public int getRowCount (int sheetIndex) {
		int rowCount = wbx.getSheetAt(sheetIndex).getLastRowNum();
		return rowCount + 1;
	}
}