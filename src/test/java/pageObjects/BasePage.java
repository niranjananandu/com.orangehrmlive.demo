package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	WebDriver driver;
	
	public BasePage(WebDriver driver) {
		this.driver =  driver;
	}
	
	public void wait(ExpectedCondition condition, Duration seconds) {
		seconds =  seconds!=null?seconds:Duration.ofSeconds(30);
		WebDriverWait wait =  new WebDriverWait(driver,seconds);
		wait.until(condition);		
	}

}
