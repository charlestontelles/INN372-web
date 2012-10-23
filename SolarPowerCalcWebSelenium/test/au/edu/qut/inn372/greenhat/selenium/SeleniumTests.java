package au.edu.qut.inn372.greenhat.selenium;



import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


import junit.framework.TestCase;

/**
 * @author Fabian Kohl
 * @version 1.0
 * 
 * Class that includes the logic for the tests
 * 
 */

public class SeleniumTests {
	
	public WebDriver driver;
	
	public void register(){
		WebElement element = driver.findElement(By.name("tabView:loginForm:register"));
		element.click();
		
		WebElement name = driver.findElement(By.name("form:name"));
		name.sendKeys("jay");
		
		WebElement email = driver.findElement(By.name("form:userProfileEmail"));
		email.sendKeys("jay@greenhat.com");
		
		WebElement password = driver.findElement(By.name("form:userProfilePassword"));
		password.sendKeys("1234");
		
		WebElement passwordAgain = driver.findElement(By.name("form:repeatPassword"));
		passwordAgain.sendKeys("1234");
		
		WebElement save = driver.findElement(By.name("form:save"));
		save.click();
		
		WebElement login = driver.findElement(By.name("form:login"));
		login.click();
	}
	
	
	
	public void verifyLogin(){
		//find the login-button and click it
		//WebElement element = driver.findElement(By.name("j_id_jsp_793657187_1:j_id_jsp_793657187_8"));
		WebElement user = driver.findElement(By.name("tabView:loginForm:inputTextEmail"));
		user.clear();
		user.sendKeys("jay@greenhat.com");
		
		WebElement pwd = driver.findElement(By.name("tabView:loginForm:inputSecretPassword"));
		pwd.sendKeys("1234");
		
		WebElement btn = driver.findElement(By.name("tabView:loginForm:buttonLogin"));
		btn.click();
		/*
		WebElement element2 = driver.findElement(By.name("j_idt12:j_idt18"));
		element2.clear();
		element2.sendKeys("1234");
		
		WebElement element3 = driver.findElement(By.name("j_idt12:j_idt20"));
		element2.click();*/
	}
	
	public void createNewCalculation(){
		WebElement newBtn = driver.findElement(By.name("tabView:form:savedCalculators:new"));
		newBtn.click();
		
	}
	
	public void verifyCustomerUsage(){
		WebElement usageTab = driver.findElement(By.linkText("Customer Usage"));
		usageTab.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement usageElement = driver.findElement(By.name("tabView:customerUsageForm:j_idt50"));
		usageElement.clear();
		usageElement.sendKeys("44.0");
		
		WebElement usageHoursElement = driver.findElement(By.name("tabView:customerUsageForm:j_idt52"));
		usageHoursElement.clear();
		usageHoursElement.sendKeys("4.5");
		
		WebElement usageTariff11 = driver.findElement(By.name("tabView:customerUsageForm:j_idt56"));
		usageTariff11.clear();
		usageTariff11.sendKeys("0.2134");
		
		WebElement usageFeedInTariff = driver.findElement(By.name("tabView:customerUsageForm:j_idt58"));
		usageFeedInTariff.clear();
		usageFeedInTariff.sendKeys("0.45");
	}
	
	public void verifyEquipement(){
		WebElement equipTab = driver.findElement(By.linkText("Equipment"));
		equipTab.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement elementEquip = driver.findElement(By.name("tabView:equipmentForm:select"));
		Select equip = new Select(elementEquip);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<WebElement> options = equip.getOptions();
		equip.selectByVisibleText(options.get(2).getText());
		
		//Select something from the spinner
		
			
	}
	
	public void verifyBanks(){
		WebElement bankTab = driver.findElement(By.linkText("Bank"));
		bankTab.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement bank1 = driver.findElement(By.name("tabView:roofForm:bank1NumberOfPanels"));
		bank1.clear();
		bank1.sendKeys("4");
		
		WebElement bank2 = driver.findElement(By.name("tabView:roofForm:bank2NumberOfPanels"));
		bank2.clear();
		bank2.sendKeys("4");
	}
	
	public void verifyCalculate(){
		WebElement summaryTab = driver.findElement(By.linkText("Summary"));
		summaryTab.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement hours = driver.findElement(By.name("tabView:summaryInputForm:sunlightHours"));
		hours.clear();
		hours.sendKeys("4.234");
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement calculate = driver.findElement(By.name("tabView:summaryInputForm:j_idt136"));
		calculate.click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
