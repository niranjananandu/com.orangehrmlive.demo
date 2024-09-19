package pageObjects;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MaintenancePageObject extends BasePage{

	public MaintenancePageObject(WebDriver driver) {
		super(driver);
	}
	
	private By menu_Maintenance = By.xpath("//a[contains(@href,'viewMaintenanceModule')]");
	private By password = By.xpath("//input[@name='password']");
	private By btn_confirm = By.xpath("//button[@type='submit']");
	private By access_records = By.xpath("//a[@class='oxd-topbar-body-nav-tab-item']");
	private By input_name = By.xpath("//input[@placeholder='Type for hints...']");
	private By input_option = By.xpath("//div[@role='option']/span");
	private By btn_search =  By.xpath("//button[normalize-space()='Search']");
	private By firstName = By.xpath("//input[@name='firstName']");
	private By middleName = By.xpath("//input[@name='middleName']");
	private By lastName = By.xpath("//input[@name='lastName']");
	private By employee_id = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
	private By btn_download = By.xpath("//button[normalize-space()='Download']");
	
	
	public void clickMaintenanceModule() {
		driver.findElement(menu_Maintenance).click();
	}
	
	public void enterCredentialsOnAdminAccess() {
		driver.findElement(password).sendKeys("admin123");
		driver.findElement(btn_confirm).click();
	}
	
	public void clickAccessRecords() {
		driver.findElement(access_records).click();
	}
	
	public void enterName(String name) {
		driver.findElement(input_name).click();
		driver.findElement(input_name).sendKeys(name);
	}
	
	public void selectEmployeeName(){
		waitFor(ExpectedConditions.visibilityOfElementLocated(input_option), Duration.ofSeconds(10));
		driver.findElement(input_option).click();
	}
	
	public void selectSearch() {
		driver.findElement(btn_search).click();
	}
	
	public boolean getFirstName() {
		return driver.findElement(firstName).isDisplayed();
	}
	public boolean getMiddleName() {
		return driver.findElement(middleName).isDisplayed();
	}
	
	public boolean getLastName() {
		return driver.findElement(lastName).isDisplayed();
	}
	
	public boolean getEmployeeID() {
		return driver.findElement(employee_id).isDisplayed();

	}
	
	public void clickDownload() {
		driver.findElement(btn_download).click();
	}
	public boolean isFileDownloaded() {
		File folder  = new File(System.getProperty("user.dir")+"\\Downloaded Files");
		File[] listOfFiles = folder.listFiles();
		boolean isFileAvailable = false;
		for(File file:listOfFiles) {
			if(file.isFile()) {
				String fileName = file.getName();
				if(fileName.matches("Peter Mac Anderson.json")) {
					isFileAvailable =  true;
				}
			}
		}return isFileAvailable;
	}
}
