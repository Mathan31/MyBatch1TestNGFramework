package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import factory.BrowserFactoryManager;

public class BaseClass {
	
	public static WebDriver driver;
	public static String browserType = "chrome"; // value should be either chorme or edge
	public static String sURL = "https://login.salesforce.com/";
	
	@BeforeClass
	public  void invokeBrowser() {
		driver = BrowserFactoryManager.getDriver(browserType).driverManager();
		driver.manage().window().maximize();
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterClass	
	public  void closeBrowser() {
		driver.quit();
	}
		

}
