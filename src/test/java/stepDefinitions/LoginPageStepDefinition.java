package stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPageObject;
import utils.TestContextSetup;

public class LoginPageStepDefinition {
	TestContextSetup context;
	LoginPageObject lpo;

	public LoginPageStepDefinition(TestContextSetup context) throws IOException {
		this.context = context;
		lpo = context.pom.createLoginPageObject();
	}

	@Given("The login page is displayed")
	public void the_login_page_is_displayed() {
		Assert.assertEquals(lpo.getUrl(), "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login",
				"Incorrect URL");
	}

	@When("The user enters a valid username {string}")
	public void the_user_enters_a_valid_username(String user) {
		context.log.info("Entering username");
		lpo.enterUsername(user);
	}

	@When("The user enters a valid password {string}")
	public void the_user_enters_a_valid_password(String pass) {
		context.log.info("Entering password");
		lpo.enterPassword(pass);
	}

	@When("The user clicks login button")
	public void the_user_clicks_login_button() {
		context.log.info("Clicking login button");
		lpo.clickLoginButton();
	}

	@When("^The user enters an invalid username (.+)$")
	public void the_user_enters_an_invalid_username(String user) {
		context.log.info("Entering invalid username");
		lpo.enterUsername(user);
	}

	@When("^The user enters an invalid password (.+)$")
	public void the_user_enters_an_invalid_password(String pass) {
		context.log.info("Entering invalid password");
		lpo.enterPassword(pass);
	}
	
	@Then("The user is shown an Invalid credentials alert")
	public void user_sees_invalid_credentials_alert() {
		Assert.assertTrue( lpo.isInvalidCredentialsAlertDisplayed(),"No alert displayed");
	}


}
