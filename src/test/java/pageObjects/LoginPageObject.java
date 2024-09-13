package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject extends BasePage {
	
	public LoginPageObject(WebDriver driver) {
		super(driver);
	}
	
	private By txt_username = By.xpath("//input[@name='username']");
	private By txt_password =  By.xpath("//input[@name='password']");
	private By btn_login = By.xpath("//button[@type='submit']");
	private By invalid_Credentials_alert = By.xpath("//div[contains(@class,'alert-content--error')]");
	
	public void enterUsername(String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLoginButton() {
		driver.findElement(btn_login).click();
	}
	
	
	public String getUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isInvalidCredentialsAlertDisplayed() {
		return driver.findElement(invalid_Credentials_alert).isDisplayed();
	}

}
