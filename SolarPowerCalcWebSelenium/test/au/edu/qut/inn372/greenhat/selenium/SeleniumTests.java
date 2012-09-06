package au.edu.qut.inn372.greenhat.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * @author Fabian Kohl
 * @version 1.0
 * 
 * Class that includes the logic for the tests
 * 
 */

public class SeleniumTests {
	
	public WebDriver driver;
	
	
	public void verifyLogin(){
		//find the login-button and click it
		WebElement element = driver.findElement(By.name("j_id_jsp_793657187_1:j_id_jsp_793657187_8"));
		element.click();
	}
	
	public void verifyEquipmentDetails(){
		//find "System Size" and enter data
		WebElement element = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_5"));
		element.clear();
		element.sendKeys("5.0");
		
		//find "Inverter Efficiency" and enter data
		WebElement element2 = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_7"));
		element2.clear();
		element2.sendKeys("95.0");	
	}
	
	public void verifyRoofDetails(){
		//find "Percentage on North Roof" and enter data
		WebElement element = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_12"));
		element.clear();
		element.sendKeys("45.0");
		
		//find "Percentage on West Roof" and enter data
		WebElement element2 = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_14"));
		element2.clear();
		element2.sendKeys("55.0");
		
		//find "Efficiency Loss(North Roof)" and enter data
		WebElement element3 = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_16"));
		element3.clear();
		element3.sendKeys("5.0");
		
		//find "Efficiency Loss(West Roof)" and enter data
		WebElement element4 = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_18"));
		element4.clear();
		element4.sendKeys("15.0");
	}
	
	public void verifySunlightDetails(){
		//find "Sunlight Details" and enter data
		WebElement element = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_20"));
		element.clear();
		element.sendKeys("4.5");
	}
	
	
	public void verifyCurrentEnergyUsageDetails(){
		//find "Energy Use Per Day" and enter data
		WebElement element = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_22"));
		element.clear();
		element.sendKeys("40.0");		
	}
	
	public void verifyCalculate(){
		//find "Calculate"-button and click it
		WebElement element = driver.findElement(By.name("j_id_jsp_910505308_1:j_id_jsp_910505308_25"));
		element.click();
	}

}
