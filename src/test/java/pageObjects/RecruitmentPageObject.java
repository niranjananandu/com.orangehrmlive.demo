package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPageObject extends BasePage {

	public RecruitmentPageObject(WebDriver driver) {
		super(driver);

	}
	private By menu_recruitment = By.xpath("//a[contains(@href,'viewRecruitmentModule')]");
	private By btn_add = By.xpath("//button[normalize-space()='Add']");
	private By first_name = By.xpath("//input[@placeholder='First Name']");
	private By middle_name = By.xpath("//input[@placeholder='Middle Name']");
	private By last_name =  By.xpath("//input[@placeholder='Last Name']");
	private By vacancy = By.xpath("//div[contains(@class,'select-text-input')]");
	String vacancy_opt ="//span[normalize-space()='";			
	private By email = By.xpath("(//input[@placeholder=\"Type here\"])[1]");
	private By contact_number =  By.xpath("(//input[@placeholder=\"Type here\"])[2]");
	private By resume = By.xpath("//input[@type='file']");
	private By keywords =By.xpath("//input[@placeholder='Enter comma seperated words...']");
	private By date =By.xpath("//input[@placeholder='yyyy-dd-mm']");	
	private By current_month = By.xpath("//div[@class='oxd-calendar-selector-month-selected']");
	private By current_year = By.xpath("//li[@class='oxd-calendar-selector-year']");
	String year = "//li[normalize-space()='";	
	String month = "//li[normalize-space()='";
	String calendar_date = "//div[@class=\"oxd-calendar-date\" and text()='";

	private By notes =By.xpath("//textarea[@placeholder='Type here']");
	private By consent_checkbox =By.xpath("//i[@class='oxd-icon bi-check oxd-checkbox-input-icon']");
	private By btn_save =By.xpath("//button[normalize-space()='Save']");
	private By toast_message = By.xpath("//p[contains(@class,'toast-message')]");
	
	public void clickRecruitmentModule() {
		driver.findElement(menu_recruitment).click();
	}

	public void clickAddCandidate() {
		driver.findElement(btn_add).click();
	}

	public void enterFirstName(String name) {
		driver.findElement(first_name).sendKeys(name);
	}

	public void enterMiddleName(String name) {
		driver.findElement(middle_name).sendKeys(name);
	}

	public void enterLastName(String name) {
		driver.findElement(last_name).sendKeys(name);
	}

	public void selectVacancy(String vacancy_option) {
		driver.findElement(vacancy).click();
		driver.findElement(By.xpath(vacancy_opt+vacancy_option+"']")).click();	
		
	}
	
	public void enterEmail(String email_val) {
		driver.findElement(email).sendKeys(email_val);
	}
	
	public void enterContactNumber(String contact) {
		driver.findElement(contact_number).sendKeys(contact);
	}
	
	public void uploadResume(String resume_path) {
		driver.findElement(resume).sendKeys(System.getProperty("user.dir")+resume_path);
	}
	
	public void enterKeywords(String keyword) {
		driver.findElement(keywords).sendKeys(keyword);

	}
	
	public void setDateOfApplication(String[] date_parts) {

		driver.findElement(date).click();
		driver.findElement(current_year).click();
		driver.findElement(By.xpath(year+date_parts[0]+"']")).click();
		driver.findElement(current_month).click();
		driver.findElement(By.xpath(month+date_parts[1]+"']")).click();
		driver.findElement(By.xpath(calendar_date+date_parts[2]+"']")).click();

	}
	
	public void enterNotes(String note) {
		driver.findElement(notes).sendKeys(note);
	}
	
	public void clickConsent() {
		driver.findElement(consent_checkbox).click();
	}

	public void clickAddCandidateSave() {
		driver.findElement(btn_save).click();
	}
	
	public String getToastMessage() {
		return driver.findElement(toast_message).getText();
	}
}
