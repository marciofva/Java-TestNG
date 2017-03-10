package com.configuration.test;

import org.testng.annotations.Parameters;

import com.pageObjects.HomePage;
import com.pageObjects.SignUpPage;
import com.pageObjects.SignUp.test.SignUpTest;
import static org.junit.Assert.assertTrue;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ConfigTest {

	protected WebDriver driver;
	private String URL = "http://automationpractice.com/index.php";
	private String title = "My Store";
	String chromeDriverLocation;
	
	protected HomePage homeObj;
	protected SignUpPage signUpObj;
	
	private static final Logger logger = LoggerFactory.getLogger(SignUpTest.class);
  
	@Parameters("browser")
	@BeforeMethod
  public void setUp(String browser) throws Throwable {
		System.out.println("browser: " + browser);
		logger.trace("setUp {}.", this.getClass());
		
		String currentDir = System.getProperty("user.dir");
		
	      switch(browser.toLowerCase()) {
	         case "chrome" :
	     		chromeDriverLocation = currentDir + "/src/main/resources/drivers/chromedriver.exe";
	    		System.setProperty("webdriver.chrome.driver", chromeDriverLocation);
	    		driver = new ChromeDriver();
	            break;
	         case "ie" :
	     		chromeDriverLocation = currentDir + "/src/main/resources/drivers/IEDriverServer.exe";
	    		System.setProperty("webdriver.ie.driver", chromeDriverLocation);
	    		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
	    		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	    		capabilities.setCapability(InternetExplorerDriver.
	    				  INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	    		InternetExplorerDriver driverIE = new InternetExplorerDriver(capabilities); 
	    		driver = driverIE;
	            break;
	         case "firefox" :
	     		chromeDriverLocation = currentDir + "/src/main/resources/drivers/geckodriver.exe";
	    		System.setProperty("webdriver.gecko.driver", chromeDriverLocation);
	    		DesiredCapabilities capabilitiesf=DesiredCapabilities.firefox();
	    		capabilitiesf.setBrowserName("FIREFOX");
	    		capabilitiesf.setPlatform(org.openqa.selenium.Platform.WINDOWS);
	    		capabilitiesf.setCapability("marionette", true);
	    		WebDriver driverFirefox = new FirefoxDriver(capabilitiesf);
	    		driver = driverFirefox;
	            break;
	          default:
	        	  Assert.assertTrue(false, "Browser '" + browser + "' is INVALID. Please, verify xml file!!!");
	      }
	      

		driver.manage().window().maximize();
		driver.navigate().to(URL);
		
		Assert.assertEquals(title, driver.getTitle());
		logger.trace("Title: '" + driver.getTitle() + "' {}.", this.getClass());
		
		moveToSignUpPage();
  }

  private void moveToSignUpPage() throws Throwable {

		logger.trace("Test Case: createAccount {}", this.getClass());
		
		homeObj = new HomePage(driver);
		
		assertTrue("Element \'" + homeObj.getLoginMenu().toString() + "\' not found for " + homeObj.getClass().getSimpleName(),homeObj.isButonClickable());

		signUpObj = homeObj.toSignUp();
	}

@AfterMethod
  public void tearDown() {
	  System.out.println("tearDown");
	  logger.trace("tearDown {}.", this.getClass());
	  driver.quit();
  }

}
