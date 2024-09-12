package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.RecruitmentPageObject;
import utils.TestContextSetup;

public class RecruitmentStepDefinition{
	
	TestContextSetup context;
	RecruitmentPageObject rpo;
	
	public RecruitmentStepDefinition(TestContextSetup context) {
		this.context = context;
		rpo = context.pom.createRecruitmentPageObject();
	}

	
	@Given("The user clicks on Recruitment Module")
	public void the_user_clicks_on_recruitment_module() {
		rpo.clickRecruitmentModule();
	}

	@When("The user clicks on the Add button")
	public void the_user_clicks_on_the_add_button() {
		rpo.clickAddCandidate();
	}

	@When("The user fills in the Add Candidate form")
	public void the_user_fills_in_the_add_candidate_form(DataTable dataTable) {
		List<List<String>> data = dataTable.asLists(String.class);
		String firstName = data.get(0).get(0);
		String middleName = data.get(0).get(1);
		String lastName = data.get(0).get(2);
		String vacancy = data.get(0).get(3);
		String email = data.get(0).get(4);
		String contact = data.get(0).get(5);
		String resume_path = data.get(0).get(6);
		String keywords = data.get(0).get(7);
		String date = data.get(0).get(8);
		String notes = data.get(0).get(9);
			
		rpo.enterFirstName(firstName);
		rpo.enterMiddleName(middleName);
		rpo.enterLastName(lastName);
		rpo.selectVacancy(vacancy);
		rpo.enterEmail(email);
		rpo.enterContactNumber(contact);
		rpo.uploadResume(resume_path);
		rpo.enterKeywords(keywords);
		rpo.setDateOfApplication(context.utils.convertDate(date));
		rpo.enterNotes(notes);
		rpo.clickConsent();
	
	}

	@When("The user clicks Save on Add Candidate")
	public void the_user_clicks_save_on_add_candidate() {
	   rpo.clickAddCandidateSave();
	}

	@Then("A success toast message is displayed")
	public void a_success_toast_message_is_displayed() {
	    Assert.assertEquals(rpo.getToastMessage(), "Successfully Saved","No match");
	}
}
