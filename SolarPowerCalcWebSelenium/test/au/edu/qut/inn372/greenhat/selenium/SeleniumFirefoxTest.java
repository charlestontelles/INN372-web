package au.edu.qut.inn372.greenhat.selenium;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author Fabian Kohl
 * @version 1.0
 * 
 * Testclass for Firefox that extends SeleniumTests
 * 
 */


public class SeleniumFirefoxTest extends SeleniumTests {
	
	
	@Before
	public void setUp() {
		// Create a new instance of the firefox unit driver
		driver = new FirefoxDriver();
		//For testing locally
		//driver.get("http://localhost:8888/");
		//Navigate to desired web page
		driver.get("http://greenhatsolarcalculatortest.appspot.com/");
		
	}
	
	@Test
	public void dataEntryTest(){

		register();
		
		verifyLogin();
		
		createNewCalculation();
		
		verifyCustomerUsage();
		
		verifyEquipement();
		
		verifyBanks();
		
		verifyCalculate();
		
	}

}
