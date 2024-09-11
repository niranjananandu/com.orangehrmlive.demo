package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.DashboardPageObject;
import utils.TestContextSetup;

public class DashboardPageStepDefinition {
	
	TestContextSetup context;
	DashboardPageObject dpo ;
	
	public DashboardPageStepDefinition(TestContextSetup context) throws IOException {
	this.context  = context;
	dpo = context.pom.createDashboardPageObject();
	}

	@Then("The user lands on the Dashboard page")
	public void the_user_lands_on_the_dashboard_page() {
		Assert.assertTrue(dpo.verifyPageTitle(),"Dashboard page not displayed"); 
	}

}
