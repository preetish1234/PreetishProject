package com.Page;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.Utilitys.log.Log;
import com.Utilitys.util;

public class Admin_Login {

	WebDriver driver;
	
	public Admin_Login(WebDriver driver){
		PageFactory.initElements(driver, this);
		
	}
	
@FindBy(how=How.XPATH,using="//input[@id='username']")
WebElement username	;

@FindBy(how=How.XPATH,using="//input[@name='login[password]']")
WebElement password;

@FindBy(how=How.XPATH,using="//button[contains(.,'Sign in')]")
WebElement Bottom;


  public void Login_Action(WebDriver driver){
	  
	  try {
		driver.manage().timeouts().pageLoadTimeout(30,TimeUnit.SECONDS);
		  
		 util.highLightElement(driver, username); 
		 ((JavascriptExecutor)driver).executeScript("document.getElementById('username').value='admin';");
		 Log.info("-->Click on userNmae");
		 
		 
		 util.highLightElement(driver, password);
		 ((JavascriptExecutor)driver).executeScript("document.getElementById('login').value='mili21sep';");  
		 Log.info("-->Click on Password");
		 
		
		 JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();",Bottom);
		  Log.info("-->Click on  login-Bottom");
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	  
  
  }



}
