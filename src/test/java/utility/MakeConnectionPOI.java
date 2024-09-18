package utility;

import java.io.FileInputStream;

//poi
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class MakeConnectionPOI {

	// poi
		public static XSSFWorkbook xlWBook;  // if not working for other excel version replace H in place of X every where
	    public static XSSFSheet xlSheet;
	    public static XSSFRow xlRow;
	    public static XSSFCell xlCell;
	    public static FileInputStream xlFile;
	    public static String wbpath;
	    
	    public static String[][]  getData(String workbookname,String sheetname) throws Exception  // define
		{
	    	wbpath = System.getProperty("user.dir")+"//src//test//java//excel//"+workbookname+".xlsx";
	    	
	    	
	    	xlFile = new FileInputStream(wbpath); // step 1 read excel file
	         
	    	// Access the required test data sheet

	         xlWBook = new XSSFWorkbook(xlFile);  // Step 2 connect to workbook
	         
                     System.out.println("connected to wb..");
                     
	         // Assuming your data is in Sheet1- if not use your own sheet name
	        
             xlSheet = xlWBook.getSheet(sheetname);  // Step 3 connect to sheet
	                System.out.println("connected to Sheet...");
	                
	         // gives row count in sheet
	         int noOfRows = xlSheet.getPhysicalNumberOfRows(); // Step 4 get row count
	               System.out.println("total rows "+noOfRows);
	         
	         xlRow = xlSheet.getRow(0);  // Step 5 go to first row position
	             System.out.println("get Row index 0");
	             
	         int noOfColumns = xlRow.getLastCellNum(); // Step 6 gives column count in sheet
	              System.out.println("total cols "+noOfColumns);
	         
	         // excelData - 2 dimm array - stores all the excel data -Sheet1 only
	         String[][] excelData = new String[noOfRows-1][noOfColumns]; // step 7 initialize array

	         // r - row is 1 because first row is column name c- column
	         for (int r = 1; r < noOfRows; r++) {
	             for (int c = 0; c < noOfColumns; c++) {
	                 xlRow = xlSheet.getRow(r); // point to row index
	                 xlCell = xlRow.getCell(c); // point to col index in row
	                 
	                 // Here we have complete excel data in an array -excelData-
	                 
	                 System.out.println("row: " + r + " column: " + c+" -- "+xlCell.getStringCellValue());
	                 
	                 excelData[r-1][c] = xlCell.getStringCellValue(); // step 8 adding data to array..
	                 // System.out.println(excelData[r][c]);
	             }
	         }

	        return excelData;

		}
	   
		public static void setData(String workbookname,String sheetname) throws Exception
		{
			 wbpath = System.getProperty("user.dir")+"//src//test//java//excel//"+workbookname+".xlsx";
			
			 xlFile = new FileInputStream(wbpath);

	        // Access the required test data sheet

	        xlWBook = new XSSFWorkbook(xlFile);

	        // Assuming your data is in Sheet1- if not use your own sheet name
	        xlSheet = xlWBook.getSheet(sheetname);

	       
	        
		}
		
	    
	    
	
}
