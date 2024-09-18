package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	LoginPageObject lpo;
	DashboardPageObject dpo;
	RecruitmentPageObject rpo;
	TimePageObject tpo;
	MaintenancePageObject mpo;
	AdminPageObject apo;
	
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
	
	public TimePageObject createTimePageObject() {
		tpo = new TimePageObject(driver);
		return tpo;
	}
	
	public MaintenancePageObject createMaintenancePageObject() {
		mpo = new MaintenancePageObject(driver);
		return mpo;
	}
	

	public AdminPageObject createAdminPageObject() {
		apo = new AdminPageObject(driver);
		return apo;
	}
}
