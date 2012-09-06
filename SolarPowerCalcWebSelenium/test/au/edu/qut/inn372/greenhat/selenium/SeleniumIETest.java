package au.edu.qut.inn372.greenhat.selenium;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * @author Fabian Kohl
 * @version 1.0
 * 
 * Testclass for IE that extends SeleniumTests
 * 
 */


public class SeleniumIETest extends SeleniumTests {
	

	
	@Before
	public void setUp() {
		// Create a new instance of the IE unit driver
		driver = new InternetExplorerDriver();

		//Navigate to desired web page
		driver.get("http://solarpowercalcweb.appspot.com/");
	}
	
	@Ignore
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
