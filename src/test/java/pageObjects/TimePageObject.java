package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TimePageObject extends BasePage {
	
	public TimePageObject(WebDriver driver) {
		super(driver);
	}

	private By menu_Time = By.xpath("//a[contains(@href,'viewTimeModule')]");
	private By timesheets_dropdown = By.xpath("//li[@class='oxd-topbar-body-nav-tab --parent --visited']");
	private By my_timesheets = By.xpath("(//a[@role='menuitem'])[1]");
	private By toast_message = By.xpath("//p[contains(@class,'toast-message')]");
	private By edit_timesheet = By.xpath("//button[contains(@class,'button--ghost')]");
	private By input_project = By.xpath("//input[@placeholder='Type for hints...']");
	private By first_option= By.xpath("(//div[@role='option'])[1]");
	private By activity= By.xpath("//div[@class='oxd-select-text oxd-select-text--active']");
	private By activity_bugFixes = By.xpath("//span[normalize-space()='Bug Fixes']");
	private By duration_input = By.xpath("//input[contains(@class,'input--active')]");
	private By save_timesheet = By.xpath("//button[@type='submit']");
	private By delete_icon = By.xpath("//i[@class='oxd-icon bi-trash']");
	
	public void clickTimeModule() {
		driver.findElement(menu_Time).click();
	}
	
	public void clickTimesheetsDropDown() {
		driver.findElement(timesheets_dropdown).click();
	}
	
	public void clickMyTimesheets() {
		driver.findElement(my_timesheets).click();
	}
	
	public void clickEditButton() {
		driver.findElement(edit_timesheet).click();
	}
	
	public void clickDeleteButton() {
		driver.findElement(delete_icon).click();
	}
	
	public void typeProject(String prompt)  {
		driver.findElement(input_project).sendKeys(prompt);		
		waitFor(ExpectedConditions.visibilityOfElementLocated(first_option), Duration.ofSeconds(10));
	}
	
	public void SelectFirstOption()  {
		Actions action =  new Actions(driver);		
		action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
	}
	
	public void selectActivity() {
		driver.findElement(activity).click();
		waitFor(ExpectedConditions.visibilityOfElementLocated(activity_bugFixes), Duration.ofSeconds(10));
		driver.findElement(activity_bugFixes).click();
	}
	
	public void enterTimesheet() {
		List<WebElement> inputs = driver.findElements(duration_input);
		for(int i =0;i<inputs.size()-2;i++) {
			inputs.get(i).click();
			inputs.get(i).sendKeys("8");
		}
	}
	
	public void saveTimesheetRecord() {
		driver.findElement(save_timesheet).click();
	}
	
	public String getAlertMessage() {
		return driver.findElement(toast_message).getText();
	}
	
}
