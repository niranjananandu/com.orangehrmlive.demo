package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	WebDriver driver;

	public WebDriver setUp() throws IOException {	
		Properties prop = new Properties();
		if(driver==null) {
			driver =  new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(file);		
		driver.get(prop.getProperty("appUrl"));		
		return driver;
	}
}
