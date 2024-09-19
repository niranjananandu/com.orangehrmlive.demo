package utils;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public PageObjectManager pom;
	public WebDriver driver;
	public BaseTest base;
	public TestUtilities utils;
	public Logger log;
	
	public TestContextSetup() throws IOException {
	log = LogManager.getLogger(this.getClass());
	base = new BaseTest();
	this.driver= base.setUp();
	pom = new PageObjectManager(this.driver,log);
	utils = new TestUtilities(this.driver);
	
//	pom = new PageObjectManager(base.setUp());
//	utils = new TestUtilities(base.setUp());
	}
}
