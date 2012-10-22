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
	
	

}
