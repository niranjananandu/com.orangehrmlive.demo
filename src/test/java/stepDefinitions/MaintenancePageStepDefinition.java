package stepDefinitions;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pageObjects.MaintenancePageObject;
import utils.TestContextSetup;

public class MaintenancePageStepDefinition {
	TestContextSetup context;
	MaintenancePageObject mpo;

	public MaintenancePageStepDefinition(TestContextSetup context) {
		this.context = context;
		mpo = context.pom.createMaintenancePageObject();

	}

	@Given("The user clicks on the Maintenance module")
	public void the_user_clicks_on_the_maintenance_module() {
		mpo.clickMaintenanceModule();

	}

	@Given("The user enters valid credentials on the Administrator Access window")
	public void the_user_enters_valid_credentials_on_the_administrator_access_window() {
		mpo.enterCredentialsOnAdminAccess();
	}

	@Given("The user clicks on the Access Records Menu")
	public void the_user_clicks_on_the_access_records_menu() {
		mpo.clickAccessRecords();
	}

	@Given("The user enters {string} in the text box")
	public void the_user_enters_in_the_text_box(String name) {
		mpo.enterName(name);
	}

	@Given("The user selects the first option in the drop-down")
	public void the_user_selects_the_first_option_in_the_drop_down() {
		mpo.selectEmployeeName();
	}

	@Given("The user clicks Submit")
	public void the_user_clicks_submit() {
		mpo.selectSearch();
	}

	@Then("The user details are displayed")
	public void the_user_details_are_displayed() {
		SoftAssert sa = new SoftAssert();
		context.utils.sleep(5);
		sa.assertTrue(mpo.getFirstName());
		sa.assertTrue(mpo.getMiddleName());
		sa.assertTrue(mpo.getLastName());
		sa.assertTrue(mpo.getEmployeeID());
		sa.assertAll();
	}

	@Given("The user clicks download button")
	public void the_user_clicks_download_button() {
		mpo.clickDownload();
		context.utils.sleep(3);
	}

	@Then("The user data is downloaded")
	public void the_user_data_is_downloaded() {
		Assert.assertTrue(mpo.isFileDownloaded());
	}

}
