package stepDefinitions;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.TimePageObject;
import utils.TestContextSetup;

public class TimeStepDefinition {
	
	TestContextSetup context;
	TimePageObject tpo;
	
	public TimeStepDefinition(TestContextSetup context) {
		this.context = context;
		tpo = context.pom.createTimePageObject();
	}
	
	@Given("The user clicks on the Time Module")
	public void the_user_clicks_on_the_time_module() {
	    tpo.clickTimeModule();
	}

	@Given("The user clicks on the Timesheets drop-down")
	public void the_user_clicks_on_the_timesheets_drop_down() {
	    tpo.clickTimesheetsDropDown();
	}

	@Given("The user clicks on My Timesheets")
	public void the_user_clicks_on_my_timesheets() {
	  tpo.clickMyTimesheets();
	}

	@When("The user clicks Edit button")
	public void the_user_clicks_edit_button() {
	    tpo.clickEditButton();
	    tpo.clickDeleteButton();
	}

	@When("The user adds a new timesheet record")
	public void the_user_adds_a_new_timesheet_record() {
	   tpo.typeProject("Apa");
	   context.utils.sleep(5);
	   tpo.SelectFirstOption();
	   tpo.selectActivity();
	   tpo.enterTimesheet();
	}

	@When("The user clicks Save")
	public void the_user_clicks_save() {
	   tpo.saveTimesheetRecord();
	}

	@Then("A new timesheet record is added")
	public void a_new_timesheet_record_is_added() {
	 Assert.assertEquals(tpo.getAlertMessage(), "Successfully Saved","No match");
	}


}
