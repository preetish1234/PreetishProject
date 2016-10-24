package com.Project.preetish;

import java.sql.SQLException;
import java.util.logging.Logger;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Page.Admin_Login;
import com.Page.Content;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Apptest {
	
	protected ExtentReports report;
	protected static ExtentTest logger;
	Logger log;
	WebDriver driver;


@BeforeMethod(alwaysRun=true)
public void Logconfig()throws ClassNotFoundException, SQLException
{
PropertyConfigurator.configure("C:\\Preetish/preetish/log.properties");
}

@BeforeTest(alwaysRun=true)

public void BrowserEngin() throws Exception{

         try {
			report = com.Utilitys.BaseClass.setup();
   driver=com.Utilitys.BrowserFactory.startBrowser("firefox");
logger = report.startTest("ApplicationTestCase");
   logger.log(LogStatus.INFO, "Browser started");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

}


@Test(groups="Admin-Login",priority=1,alwaysRun=true)
public void AdminLogin(){
	
	try {
		logger = report.startTest("%%Admin-Action%%");
		
Admin_Login login= new Admin_Login(driver);
		
		login.Login_Action(driver);
		logger.log(LogStatus.PASS, "----User can Login-----");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	}


@Test(dependsOnMethods = { "AdminLogin" },groups="Content-Action",priority=2,alwaysRun=true)
public void Content_Test(){
	try {
		logger = report.startTest("%%Content-Acton%%");
		
		Content action = new Content(driver);
		logger.log(LogStatus.INFO, "-----User close the popUP-----");
		
		action.Content_action(driver);
		logger.log(LogStatus.INFO, "-----user can hover to Content-----");
		
   
		action.Configuration_action(driver);
		logger.log(LogStatus.INFO, "------click on configuration------");
		
		
		action.edit_Click_SelectTheme(driver);
   logger.log(LogStatus.INFO, "-----Click on edit && Select the theame-----");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 	

}





@AfterMethod(alwaysRun=true)
public void tearDown(ITestResult result){
	
		
	try {
		if (result.getStatus()==ITestResult.FAILURE)
			
		{
		
			String screenshot_path =com.Utilitys.util.captureScreenShot( driver, result.getName());
            String image= logger.addScreenCapture(screenshot_path);
logger.log(LogStatus.FAIL," ExtentReport ScreenShot "+ image );
		}
			
		report.endTest(logger);
		report.flush();
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}

@AfterClass(alwaysRun=true)

	public void tearDown(){
	   driver.quit();

	}
}


