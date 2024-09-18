package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class TestUtilities {
	WebDriver driver;
	
	public TestUtilities(WebDriver driver) {
		this.driver=driver;
	}
	
	public void sleep(int seconds) {
		try {
			Thread.sleep(Duration.ofSeconds(seconds));
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String[] convertDate(String date) {
		//yyyy-mm-dd
		String[] data = date.split("-");
		String mm = data[1];
		String dd = data[2];
		String month = null;
		
		switch(mm){
		case "01":  month = "January"; break;
		case "02":  month = "February"; break;
		case "03":  month = "March"; break;
		case "04":  month = "April"; break;
		case "05":  month = "May"; break;
		case "06":  month = "June"; break;
		case "07":  month = "July"; break;
		case "08":  month = "August"; break;
		case "09":  month = "September"; break;
		case "10":  month = "October"; break;
		case "11":  month = "November"; break;
		case "12":  month = "December"; break;
		}
		
		data[1] = month;
		data[2] = dd.replace(String.valueOf('0'), "");
		return data;
	}
	
	public String[] readExcelData(String filename) throws IOException {
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"//src//test//resources//Files//"+filename);
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet =  workbook.getSheet("Sheet1");
		int rows = sheet.getLastRowNum();
		XSSFRow row =  sheet.getRow(0);
		int columns =  row.getLastCellNum();
		String[] arr =  new String[columns];
	
		
			XSSFRow currentRow= sheet.getRow(1);
			for(int j =0;j<columns;j++) {				
				try {
					arr[j]= currentRow.getCell(j).toString();
				} catch (Exception e) {
					arr[j] = "";
				}
			} 
			System.out.println(arr);		
		workbook.close();
		file.close();
		return arr;
	}

}
