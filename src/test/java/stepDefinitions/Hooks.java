package stepDefinitions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.service.ExtentService;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utils.TestContextSetup;

public class Hooks {
	WebDriver driver;
	TestContextSetup context;

	public Hooks(TestContextSetup context) throws IOException {
		this.context = context;
	}

	@BeforeAll
	public static void before_or_after_all() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		prop.load(file);
		ExtentReports extent = ExtentService.getInstance();
		extent.setSystemInfo("Operating System", prop.getProperty("os.name"));
		extent.setSystemInfo("User Name", System.getProperty("user.name"));
		extent.setSystemInfo("Browser", prop.getProperty("browser"));
		extent.setSystemInfo("Environment", prop.getProperty("environment"));
		extent.setSystemInfo("Tester", prop.getProperty("tester"));
	}

	@After
	public void tearDown() {
		context.driver.quit();
	}

	@AfterStep
	public void takeScreenshot(Scenario scenario) throws IOException {
		if (scenario.isFailed()) {
			File file = ((TakesScreenshot) context.driver).getScreenshotAs(OutputType.FILE);
			byte[] byteFile = FileUtils.readFileToByteArray(file);
			scenario.attach(byteFile, "image/png", "screenshot");
		}

	}

}
