package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPageObject extends BasePage {

	private By dashboard_title = By.xpath("//div[@class='oxd-topbar-header-title']");
	private By menu_PIM = By.xpath("//a[contains(@href,'viewPIMModule')]");
	private By menu_Leave = By.xpath("//a[contains(@href,'viewLeaveModule')]");	
	private By menu_myInfo = By.xpath("//a[contains(@href,'viewMyDetails')]");

	public DashboardPageObject(WebDriver driver) {
		super(driver);
	}

	public boolean verifyPageTitle() {
		return driver.findElement(dashboard_title).isDisplayed();
	}



	public void clickPIMModule() {
		driver.findElement(menu_PIM).click();
	}

	public void clickLeaveModule() {
		driver.findElement(menu_Leave).click();
	}

	

	public void clickMyInfoModule() {
		driver.findElement(menu_myInfo).click();
	}
}
