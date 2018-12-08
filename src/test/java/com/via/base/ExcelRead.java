package com.via.base;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead{
	static Sheet sheet;
	public static void excelConfig(String location, String sheetName) {
			Workbook wBook = null;
			try {
				FileInputStream fin = new FileInputStream(location);
				if(location.endsWith(".xls"))
					wBook = new HSSFWorkbook(fin);
				else if(location.endsWith(".xlsx"))
					wBook = new XSSFWorkbook(fin);
				else
					System.out.println("File specified is not an Excel File");
			} catch (Exception e) {
				e.printStackTrace();
			}
			sheet = wBook.getSheet(sheetName);
	}
	
	public static String read(int row, int col) {
			if(sheet==null) 
				return null;
			String value = sheet.getRow(row).getCell(col).toString();
			if(value.endsWith(".0")) value = value.split("\\.")[0];
			return value;
	}
	
	public static int lastCell(int row) {
		if(sheet != null) 
			return sheet.getRow(row).getLastCellNum();
		return 0;
	}
	
	public static int lastRow() {
		if(sheet != null) 
			return sheet.getLastRowNum();
		return 0;
	}

	public static int ROWNUM() {
		return sheet.getLastRowNum();
	}
}