package com.AUTOMATIONPRACTICE.coreUtility;

import java.io.FileInputStream;
	import java.io.FileOutputStream;
	import java.io.IOException;

	import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	/**
	 * This class is used to maintain all excel specific common methods
	 * @author Roopa
	 *
	 */
	public class ExcelUtility {
	
		 static Workbook wb;
		
		
		
	/**
	 * This method is used to fetch the data from the excel sheet
	 * @param filePath
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		public static String getDataFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException
		{
		    
			String data = wb.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
		     return data;  
		}
		/**
		 * this method is used to open the excel
		 * @param filePath
		 * @throws EncryptedDocumentException
		 * @throws IOException
		 */
		public static void openExcel(String filePath) throws EncryptedDocumentException, IOException
		{
		    
		   FileInputStream file = new FileInputStream(filePath);
		   wb=WorkbookFactory.create(file);  
		}
		
		/**
		 * this method is used to sav the data into the excel file
		 * @param filesavepath
		 * @throws IOException
		 */
		public static void writeIntoExcel(String filesavepath) throws IOException
		{
			FileOutputStream file2 = new FileOutputStream(filesavepath);
			wb.write(file2);
		}
		
		/**
		 * 
		 * @param filepath
		 * @throws IOException
		 */
		public static void closeExcel() throws IOException
		{
			wb.close();
		}
		/**
		 * This method is used to set the Value into Excel
		 * @param sheetName
		 * @param rowNumber
		 * @param cellNumber
		 * @param value
		 */
		public static void setCellvalue(String sheetName,int rowNumber,int cellNumber,String value)
		{
			wb.getSheet(sheetName).getRow(rowNumber).createCell(cellNumber).setCellValue(value);
		}
		
		public static Object[][] getMultipleDataFromExcel(String sheetName)
		{
			Sheet sh = wb.getSheet(sheetName);
			Object[][] arr = new Object[sh.getLastRowNum()+1
			                            ][sh.getRow(0).getLastCellNum()];
			for(int i=0;i<=sh.getLastRowNum();i++)
			{
				for(int j=0;j<sh.getRow(i).getLastCellNum();j++)
				{
					arr[i][j]=sh.getRow(i).getCell(j).getStringCellValue();
				}
			}
			return arr;
		}

	



}
