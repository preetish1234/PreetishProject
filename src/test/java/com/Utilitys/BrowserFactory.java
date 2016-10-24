package com.Utilitys;






import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverService;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerDriverService;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Parameters;






public class BrowserFactory
      {
      
 static WebDriver driver;
	protected static RemoteWebDriver driver1;
	static final String PROXY = "http://online-shoping.myavactis.com/admin/";
	@Parameters("Browser")
	
		public static WebDriver startBrowser(String browserName)throws MalformedURLException
		{
			
			
		
			if (browserName.equalsIgnoreCase("firefox"))
			{

				try {
					DesiredCapabilities capabilities = DesiredCapabilities.firefox();
				    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
					capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
				    capabilities.setJavascriptEnabled(true);
				    capabilities.setCapability("cssSelectorsEnabled", true);
				    capabilities.setCapability("applicationCacheEnabled", true);
				    capabilities.setCapability("acceptSslCerts",true);
				    capabilities.setCapability(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.firefox.marionette","C:\\Users\\preetish\\Downloads\\Compressed\\geckodriver.exe"));
				    
				    	driver =new FirefoxDriver(capabilities);
				} catch (Exception e) {
					
				e.printStackTrace();
				}
				
				
			}
			else if(browserName.equalsIgnoreCase("crome"))
			{
				try {
				//	System.setProperty("webdriver.chrome.driver","C:\\Users\\preetish\\Downloads\\Compressed\\chromedriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
					capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
					capabilities.setJavascriptEnabled(true);
				    capabilities.setCapability("cssSelectorsEnabled", true);
				    capabilities.setCapability("applicationCacheEnabled", true);
				    capabilities.setCapability("acceptSslCerts",true);
				    capabilities.setCapability(ChromeDriverService.CHROME_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.chrome.driver", 
				    		                                   "C:\\Users\\preetish\\Downloads\\Compressed\\chromedriver.exe"));
					driver= new ChromeDriver(capabilities);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			else if (browserName.equalsIgnoreCase("IE"))
			{		
 try {
	 
	 
	 
	             org.openqa.selenium.Proxy proxy = new org.openqa.selenium.Proxy();	 
	    		 proxy.setHttpProxy(PROXY)
	    		      .setFtpProxy(PROXY)
	    		      .setSslProxy(PROXY);
	    		 DesiredCapabilities cap = DesiredCapabilities.internetExplorer();
	    		 cap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					cap.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					cap.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
					cap.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
	    		    cap.setCapability(CapabilityType.PROXY, proxy);
	    		    cap.setJavascriptEnabled(true);
	    
				    cap.setCapability("cssSelectorsEnabled", true);
				    cap.setCapability("applicationCacheEnabled", true);
				    cap.setCapability("acceptSslCerts",true);
	    	cap.setCapability(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.ie.driver", 
	    				 "C:\\Users\\preetish\\Downloads\\Compressed\\IEDriverServer.exe"));
	    
	    	driver = new InternetExplorerDriver(cap);
	             
	             
	             
	             
				 /*   DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
				    capabilities.setJavascriptEnabled(true);
				    capabilities.setCapability("cssSelectorsEnabled", true);
				    capabilities.setCapability("applicationCacheEnabled", true);
				    capabilities.setCapability("acceptSslCerts",true);
				    capabilities.setCapability(InternetExplorerDriverService.IE_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.ie.driver",
				    		                                           "C:\\Users\\preetish\\Downloads\\Compressed\\IEDriverServer.exe"));
				    driver = new InternetExplorerDriver(capabilities);*/
        }  catch (Exception e) {
 	       e.printStackTrace();
    
   }
			}
			
			
			else if (browserName.equalsIgnoreCase("edge"))
			{		
 try {
	//System.setProperty("webdriver.edge.driver", "C:\\Users\\preetish\\Downloads\\Compressed\\MicrosoftWebDriver.exe");
				    DesiredCapabilities capabilities = DesiredCapabilities.edge();
				    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
				    capabilities.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					capabilities.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
					capabilities.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
				    capabilities.setJavascriptEnabled(true);
				    capabilities.setCapability("cssSelectorsEnabled", true);
				    capabilities.setCapability("applicationCacheEnabled", true);
				    capabilities.setCapability("acceptSslCerts",true);
				    capabilities.setCapability(EdgeDriverService.EDGE_DRIVER_EXE_PROPERTY,System.setProperty("webdriver.edge.driver",
				    		                                           "C:\\Users\\preetish\\Downloads\\Compressed\\MicrosoftWebDriver.exe"));
				    driver = new EdgeDriver(capabilities);
} catch (Exception e) {
 	       e.printStackTrace();
    
   }
			}
			
		
			else if(browserName.equalsIgnoreCase("phantomJS"))
				
			
			{
				
				
				try {
					DesiredCapabilities caps = DesiredCapabilities.phantomjs();
					caps.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
					caps.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
					caps.setCapability(CapabilityType.ELEMENT_SCROLL_BEHAVIOR, true);
					caps.setCapability(CapabilityType.SUPPORTS_FINDING_BY_CSS, true);
					caps.setJavascriptEnabled(true);
					caps.setCapability("cssSelectorsEnabled", true);
					caps.setCapability("applicationCacheEnabled", true);
					caps.setCapability("acceptSslCerts",true);
					caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,"C:\\Users\\preetish\\Downloads\\Compressed\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe"); 
					driver = new PhantomJSDriver(caps);
				} catch (Exception e) {
				
					e.printStackTrace();
				}			    
					
			}
			
			else if(browserName.equalsIgnoreCase("grid"))
			{
				try {
					
					
			
					DesiredCapabilities cap=DesiredCapabilities.chrome();
					 
					// Set the platform where we want to run our test- we can use MAC and Linux and other platforms as well
					 cap.setPlatform(Platform.WINDOWS);
					 cap.setBrowserName(BrowserType.CHROME);
			
					 
					 //	URL url=new URL("http://localhost:4444/wd/hub");
		driver1=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), cap);
		
				    
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
				
				
			try {
				driver.manage().deleteAllCookies();
				driver.manage().window().maximize();
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.get(PROXY);
				driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			return driver;

            }
	
		
}