package com.Page;


import java.util.concurrent.TimeUnit;





import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;









import com.Utilitys.log.Log;
import com.Utilitys.util;
import com.google.common.base.Function;

public class Content {
	
	WebDriver driver;
	
	public Content(WebDriver driver){
PageFactory.initElements(driver, this);

	}
//1 method	step
	
	@FindBy(how=How.XPATH,using="//a[contains(.,'Content')]")
	WebElement Content_Menu ;

	@FindBy (how=How.XPATH,using="//button[@class='action-close']")
	WebElement Pop_close;
		
public void Content_action(WebDriver driver){
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
			JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();",Pop_close);
	              Log.info("-->User close the popUP");
	
	
	
	util.Hover(driver, Content_Menu);
	Log.info("-->Hover to Content-Tab");
	
	
}
	//2 method Step
	@FindBy(how=How.XPATH,using=".//*[@id='menu-magento-backend-content']//*[text()='Configuration']")
	WebElement Configuration_tab;
	public void Configuration_action(WebDriver driver){
		
		//new WebDriverWait(driver, 60).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='submenu']")));
	 Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
	         .withTimeout(90, TimeUnit.SECONDS)
	         .pollingEvery(250, TimeUnit.MILLISECONDS)
	         .ignoring(NoSuchElementException.class);
	        
	         WebElement element1 = wait.until(new Function<WebDriver, WebElement>() 
	        		 {
	       public WebElement apply(WebDriver driver) 
	{

	    // find the element

	     WebElement ele = driver.findElement(By.xpath(".//*[@id='menu-magento-backend-content']//*[text()='Configuration']"));

	        String value = ele.getAttribute("innerHTML");

	                   if (value.equalsIgnoreCase("Configuration")) 
	                    { 

	                        return ele;

	                   }
	                   else
	                   {
	      System.out.println("Text wil come oc screen >>> "+value);
	       Log.info("Text wil come oc screen >>> "+value);
	         return null;
	              }
	           }

	        });
	         System.out.println("Final visible status is >>>>> " + element1.isDisplayed());
	
	         JavascriptExecutor executor1 = (JavascriptExecutor)driver;
	 		executor1.executeScript("arguments[0].click();",Configuration_tab );
Log.info("Click on config");
}

// 3 method
		

	
@FindBy(how=How.XPATH,using="//*[text()='Action']//following::a[text()='Edit'][1]")
WebElement Text_Tab;
@FindBy(how=How.XPATH,using="//*[text()='Applied Theme']//following::*[@class='admin__control-select'][1]")
WebElement DropDown_Select;
@FindBy(how=How.XPATH,using="//option[@data-title='Magento Blank']")
WebElement magentoBlack;
@FindBy(how=How.XPATH,using="//*[text()='HTML Head']")
WebElement Html_Head;
@FindBy(how=How.XPATH,using="//*[text()='Favicon Icon']")
WebElement Uplod;
@FindBy(how=How.XPATH,using="//*[text()='Default Title']//following::*[@class='admin__control-text'][1]")
WebElement Text_Edit;
@FindBy(how=How.XPATH,using="//*[text()='Default Keywords']//following::*[@class='admin__control-textarea'][1]")
WebElement KeyWord;
@FindBy(how=How.XPATH,using="//*[text()='Default Description']//following::*[@class='admin__control-textarea'][1]")
WebElement Description;
public void edit_Click_SelectTheme(WebDriver driver){
	
	
	
	try {
		
		
		
		util.isElementPresnt(driver, "//*[text()='Action']//following::a[text()='Edit'][1]", 60);
		

		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();",Text_Tab);
	Log.info("--->> click on edit");
	
	
	
	util.isElementPresnt(driver, "//*[text()='Applied Theme']//following::*[@class='admin__control-select'][1]", 60);
	util.HoverAndClick(driver, DropDown_Select, DropDown_Select);
	
	
	
	util.isElementPresnt(driver, "//option[@data-title='Magento Blank']", 60);
	
	Select oSelect = new Select(driver.findElement(By.xpath("//*[text()='Applied Theme']//following::*[@class='admin__control-select'][1]")));
	 
	oSelect.selectByVisibleText("Magento Blank");
	
	JavascriptExecutor executor2 = (JavascriptExecutor)driver;
	
	executor2.executeScript("arguments[0].click();",magentoBlack);
	
	Log.info("click on Magento BLack");
	
	
	
	((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",Html_Head);
	
JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	
	executor3.executeScript("arguments[0].click();",Html_Head);
Log.info("----->>>>clkick on html_Head");

JavascriptExecutor executor4 = (JavascriptExecutor)driver;

executor4.executeScript("arguments[0].click();",Uplod);
Log.info("----->>>>click on upload");
	

Runtime.getRuntime().exec("C:\\Users\\preetish\\Desktop\\autoit\\imageupload.exe");	
Log.info("--->>>>image upload sucessfully");

	
JavascriptExecutor executor5 = (JavascriptExecutor)driver;

executor5.executeScript("arguments[0].click();",Text_Edit);
Log.info("----->>>>click to edit");

Text_Edit.clear();
Text_Edit.sendKeys("Preetish hub");
Log.info("---->>Edit");



JavascriptExecutor executor6 = (JavascriptExecutor)driver;
executor6.executeScript("arguments[0].click();",KeyWord);
Log.info("----->>>>click to KEyword");

KeyWord.clear();
KeyWord.sendKeys("Preetish online shopping");
Log.info("---->>Edit");

JavascriptExecutor executor7 = (JavascriptExecutor)driver;
executor7.executeScript("arguments[0].click();",Description);
Log.info("----->>>>click to edit");

Description.clear();
Description.sendKeys("Preetish project");
Log.info("---->>Edit");



	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}


}

}

