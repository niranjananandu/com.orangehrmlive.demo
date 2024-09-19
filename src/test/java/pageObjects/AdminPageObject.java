package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AdminPageObject extends BasePage{

	public AdminPageObject(WebDriver driver) {
		super(driver);
	}
	private By menu_admin = By.xpath("//a[contains(@href,'viewAdminModule')]");
	private By user_management = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent --visited']");	
	private By users = By.xpath("//ul[@role='menu']//li");
	private By btn_add = By.xpath("//button[normalize-space()='Add']");
	private By title_add_user = By.xpath("//h6[normalize-space()='Add User']");
	private By userRole_select = By.xpath("(//div[@class=\"oxd-select-text-input\"])[1]");
	private By employee_name = By.xpath("//input[@placeholder='Type for hints...']");
	private By status_select =  By.xpath("(//div[@class=\"oxd-select-text-input\"])[2]");
	private By username = By.xpath("(//input[@data-v-1f99f73c])[2]");
	private By password = By.xpath("(//input[@type='password'])[1]");
	private By confirm_password = By.xpath("(//input[@type='password'])[2]");
	String role_value = "//span[contains(text(),'";
	private By btn_save = By.xpath("//button[@type='submit']");
	private By system_users_title = By.xpath("//h5[normalize-space()='System Users']");
	private By employee_name_val =  By.xpath("//span[normalize-space()='Thomas Kutty Benny']");
	private By search_btn = By.xpath("//button[normalize-space()='Search']");
	String user_record = "(//div[@class=\"oxd-table-card\"])[1]/div/div[";
	private By record_title =  By.xpath("//span[normalize-space()='(1) Record Found']");
	
		public void clickAdminModule() {
		driver.findElement(menu_admin).click();
	}
		
		public void clickUsersTab() {
			driver.findElement(user_management).click();
			driver.findElement(users).click();
		}
		
		public void clickAddUser() {
			driver.findElement(btn_add).clear();
			waitFor(ExpectedConditions.visibilityOfElementLocated(title_add_user),Duration.ofSeconds(10));
		}

		public void enterUserDetails(String[] data) {		
			
			driver.findElement(userRole_select).click();
			driver.findElement(By.xpath(role_value+data[0]+"')]")).click();
			
			driver.findElement(employee_name).click();
			driver.findElement(employee_name).sendKeys(data[1]);
			waitFor(ExpectedConditions.visibilityOfElementLocated(employee_name_val), Duration.ofSeconds(10));
			driver.findElement(employee_name_val).click();
			
			driver.findElement(status_select).click();
			driver.findElement(By.xpath(role_value+data[2]+"')]")).click();
			
			driver.findElement(username).click();
			driver.findElement(username).sendKeys(data[3]);
			
			driver.findElement(password).click();
			driver.findElement(password).sendKeys(data[4]);
			
			driver.findElement(confirm_password).click();
			driver.findElement(confirm_password).sendKeys(data[5]);
						
			}
		
		public void clickSave() {
			driver.findElement(btn_save).click();
			waitFor(ExpectedConditions.visibilityOfElementLocated(system_users_title), Duration.ofSeconds(10));
		}
		
		public void searchUsername() {
			driver.findElement(username).click();
			driver.findElement(username).sendKeys("tommy");
			driver.findElement(search_btn).click();
			waitFor(ExpectedConditions.visibilityOfElementLocated(record_title), Duration.ofSeconds(10));			
		}
		
		public String[] getUserDetails() {
			// (//div[@class=\"oxd-table-card\"])[1]/div/div[2]/div
			String[] data=new String[4];
			for (int i =2;i<=5;i++) {
				data[i-2]=driver.findElement(By.xpath(user_record+i+"]/div")).getText();
			}
			return data;
		}
				
			
		}
		