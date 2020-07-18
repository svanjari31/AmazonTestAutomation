package com.amazon.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.interactions.Actions;

import com.amazon.qa.base.TestBase;
import com.amazon.qa.pages.LoginPage;

public class TestUtil extends TestBase{
	
	LoginPage loginPage;
	
	public static long PAGE_LOAD_TIMEOUT = 30;
	public static long IMPLICIT_WAIT = 30;
	public static String TESTDATA_SHEET_PATH = "E:/Selenium/POM/TestProject/src/main/java/com/amazon/qa/testdata/excelData.xlsx";
	static Workbook book;
	static Sheet sheet;
	
	public void moveToElement() {
		new Actions(driver).moveToElement(loginPage.getAccount()).build().perform();
	}
	
	public static void switchToWindowHandle() {
		Set<String> windowHandle = driver.getWindowHandles();
		for(String handle : windowHandle)
		{
			log.info("Getting window handles"+handle);
			driver.switchTo().window(handle);
		}
		
	}
	
	public void switchToFrame() {
		
		driver.switchTo().frame("ue_back");
		
	}
	
	public static Object[][] getTestData(String sheetName) {
		FileInputStream file = null;
		
		try {
			file = new FileInputStream(TESTDATA_SHEET_PATH);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		
		try {
			book = WorkbookFactory.create(file);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		sheet = book.getSheet(sheetName);
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i = 0; i<sheet.getLastRowNum(); i++)
		{
			for(int k = 0; k<sheet.getRow(0).getLastCellNum(); k++)
			{
				data[i][k] = sheet.getRow(i+1).getCell(k).toString();
			}
		}
		
		return data;
		
	}
	

}
