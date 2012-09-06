package au.edu.qut.inn372.greenhat.selenium;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Fabian Kohl
 * @version 1.0
 * 
 * Testclass for Chrome that extends SeleniumTests
 * 
 */



public class SeleniumChromeTest extends SeleniumTests {
	
	
	@Before
	public void setUp() {
		// Create a new instance of the chrome unit driver
		driver = new ChromeDriver();

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


