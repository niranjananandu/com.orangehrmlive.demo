package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectManager;

public class TestContextSetup {

	public PageObjectManager pom;
	public WebDriver driver;
	public BaseTest base;
	public TestUtilities utils;
	
	
	public TestContextSetup() throws IOException {
	base = new BaseTest();
	this.driver= base.setUp();
	pom = new PageObjectManager(this.driver);
	utils = new TestUtilities(this.driver);
	
//	pom = new PageObjectManager(base.setUp());
//	utils = new TestUtilities(base.setUp());
	}
}
