package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
	
	WebDriver driver;	

	public WebDriver setUp() throws IOException {	
		Properties prop = new Properties();
		
		if(driver==null) {
			ChromeOptions options = new ChromeOptions();
			Map<String,Object> prefs =  new HashMap<String,Object>();
			prefs.put("download.default_directory", System.getProperty("user.dir")+"\\Downloaded Files");
			options.setExperimentalOption("prefs", prefs);
			driver =  new ChromeDriver(options);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		}
		
		FileInputStream file =  new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		prop.load(file);	
       
		driver.get(prop.getProperty("appUrl"));	
		driver.manage().window().maximize();
		return driver;
	}
}
