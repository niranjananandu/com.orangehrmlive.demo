package stepDefinitions;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	WebDriver driver;
	
	TestContextSetup context;
	
	public Hooks(TestContextSetup context) throws IOException {
	this.context=context;
	
	}
	
	@After
	public void tearDown() {
		context.driver.quit();	
	}
	
	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if(scenario.isFailed()) {
			File file = ((TakesScreenshot)context.driver).getScreenshotAs(OutputType.FILE);
			byte[] byteFile= FileUtils.readFileToByteArray(file);
			scenario.attach(byteFile, "image/png", "screenshot");
		}
		
	}

}
