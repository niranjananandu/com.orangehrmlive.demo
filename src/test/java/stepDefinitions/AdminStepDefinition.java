package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.AdminPageObject;
import utils.TestContextSetup;

public class AdminStepDefinition {
	TestContextSetup context;
	AdminPageObject apo;
	
	
	public AdminStepDefinition(TestContextSetup testContextSetup) {
		this.context = testContextSetup;
		apo = context.pom.createAdminPageObject();
		
	}
	
		@Given("The user clicks on the Admin module")
	public void the_user_clicks_on_the_admin_module() {
	   apo.clickAdminModule();
	}

	@Given("The user clicks on the User Management tab")
	public void the_user_clicks_on_the_user_management_tab() {
	    apo.clickUsersTab();
	}

	@Given("The user fills in the user data")
	public void the_user_fills_in_the_user_data() throws IOException {
		String[] data = context.utils.readExcelData("Admin.xlsx");
		apo.enterUserDetails(data);
	}

	@Given("The user clicks save")
	public void the_user_clicks_save() {
	    apo.clickSave();
	}

	@Given("The user searches by the username")
	public void the_user_searches_by_the_username() {
		apo.searchUsername();
		
	}

	@Then("The added user is displayed")
	public void the_added_user_is_displayed() {
		String[] expectedData = {"tommy","Admin","Thomas Benny","Enabled"};
	    String[] data = apo.getUserDetails();
	    System.out.print(expectedData);
	    System.out.print(data);
	    
	    Assert.assertEquals(data, expectedData,"No match");
	    
	}

}
