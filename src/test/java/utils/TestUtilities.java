package utils;

import java.time.Duration;

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

}
