package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/java/features",
		glue = "stepDefinitions",
		monochrome = true,
		plugin= {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","html:target/cucumber.html","json:target/cucumber.json"})
public class TestNGRunner extends AbstractTestNGCucumberTests {
	
//	@Override
//	@DataProvider(parallel=true)
//	public Object[][] scenarios(){
//		return super.scenarios();
//	}

}
