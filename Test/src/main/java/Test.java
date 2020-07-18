import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Test {
	
	public static void main(String[] agrs) {
		
		File file = new File("E:/Selenium/excel.xlsx");
		FileInputStream fp;
		try {
			
			fp = new FileInputStream(file);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fp);
		XSSFSheet sheet = workbook.getSheetAt(0);
		sheet.getRow(2).createCell(0).setCellValue("Tom");
		sheet.getRow(2).createCell(1).setCellValue("200");
		sheet.getRow(3).createCell(0).setCellValue("Naveen");
		sheet.getRow(3).createCell(1).setCellValue("100");
		
		FileOutputStream fout = new FileOutputStream(file);
		workbook.write(fout);
		fout.close();
		
		for(int i=0; i<=sheet.getLastRowNum(); i++)
		{
			for(int k=0; k<2; k++)
			{
				System.out.print(sheet.getRow(i).getCell(k).getStringCellValue());
			}
			System.out.println(" ");
			
		}
		
		
		}
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

