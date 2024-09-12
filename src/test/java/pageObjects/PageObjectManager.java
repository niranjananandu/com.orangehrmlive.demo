package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	LoginPageObject lpo;
	DashboardPageObject dpo;
	RecruitmentPageObject rpo;
	
	public PageObjectManager(WebDriver driver) {
		this.driver= driver;
	}
	
	public LoginPageObject createLoginPageObject() {
		lpo = new LoginPageObject(driver);
		return lpo;
	}
	
	public DashboardPageObject createDashboardPageObject() {
		dpo = new DashboardPageObject(driver);
		return dpo;
	}

	public RecruitmentPageObject createRecruitmentPageObject() {
		rpo = new RecruitmentPageObject(driver);
		return rpo;
	}
}
