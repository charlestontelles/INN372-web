package au.edu.qut.inn372.greenhat.selenium;

import org.junit.Before;
import org.junit.Test;
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

		//Navigate to desired web page
		driver.get("http://solarpowercalcweb.appspot.com/");
	}
	
	@Test
	public void dataEntryTest(){
		
		verifyLogin();
		
		verifyEquipmentDetails();
		
		verifyRoofDetails();
		
		verifySunlightDetails();
		
		verifyCurrentEnergyUsageDetails();
		
		verifyCalculate();
		
	}

}