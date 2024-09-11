package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage{
	
	private By dashboard_title = By.xpath("//h6[normalize-space()='Dashboard']");
	
	public DashboardPageObject(WebDriver driver) {
		super(driver);
	}

	public boolean verifyPageTitle() {
		return driver.findElement(dashboard_title).isDisplayed();
	}
	
}
