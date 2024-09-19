package pageObjects;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	WebDriver driver;
	Logger log;
	LoginPageObject lpo;
	DashboardPageObject dpo;
	RecruitmentPageObject rpo;
	TimePageObject tpo;
	MaintenancePageObject mpo;
	AdminPageObject apo;
	
	public PageObjectManager(WebDriver driver,Logger log) {
		this.driver= driver;
		this.log=log;
	}
	
	public LoginPageObject createLoginPageObject() {
		log.info("Creating Login Page Object");
		lpo = new LoginPageObject(driver);
		return lpo;
	}
	
	public DashboardPageObject createDashboardPageObject() {
		log.info("Creating Dashboard Page Object");
		dpo = new DashboardPageObject(driver);
		return dpo;
	}

	public RecruitmentPageObject createRecruitmentPageObject() {
		log.info("Creating Recruitment Page Object");
		rpo = new RecruitmentPageObject(driver);
		return rpo;
	}
	
	public TimePageObject createTimePageObject() {
		log.info("Creating Time Page Object");
		tpo = new TimePageObject(driver);
		return tpo;
	}
	
	public MaintenancePageObject createMaintenancePageObject() {
		log.info("Creating Maintenance Page Object");
		mpo = new MaintenancePageObject(driver);
		return mpo;
	}
	

	public AdminPageObject createAdminPageObject() {
		log.info("Creating Admin Page Object");
		apo = new AdminPageObject(driver);
		return apo;
	}
}
