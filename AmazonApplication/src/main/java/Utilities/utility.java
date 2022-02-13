package Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class utility {
	
	public static String getDataFromExcelSheet(String sheet,int row,int col) throws IOException
	  {
		
		    String infodata = "C:\\Users\\RAJAT\\Desktop\\ExcellSheet\\Book1.xlsx";
		    FileInputStream file = new FileInputStream(infodata);
	        String sheet2=WorkbookFactory.create(file).getSheet("Rajat").getRow(row).getCell(col).getStringCellValue(); 
		    return sheet2;
	  }
	 public static void getScreenshot(WebDriver driver,int Testid) throws IOException
	  {
		 
		    DateFormat date = new SimpleDateFormat("MM dd yyyy HH mm ss");
		    Date systemdate=new Date();
		    String currentDate=date.format(systemdate);
		    File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		    File dest = new File("C:\\Users\\RAJAT\\Desktop\\sceenshot\\Rajat"+Testid+"_"+currentDate+ ".jpeg");
	    	FileHandler.copy(file, dest);
	    	
	  }
	

}
