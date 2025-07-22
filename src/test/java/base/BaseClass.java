package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import factory.BrowserFactoryManager;
import utils.PropertyFileUtil;
import wrapper.HTMLReport;

public class BaseClass extends HTMLReport{
	
	public WebDriver driver; //null --> 123 --> null
	public static String propFileName = "Environment";
	public static String browserType = PropertyFileUtil.readDataFromPropertyFile(propFileName, "Browser"); // value should be either chorme or edge
	public static String sURL = PropertyFileUtil.readDataFromPropertyFile(propFileName, "URL");
	public String excelFileName = "";
	
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
	
	@DataProvider(name="TestCaseData")
	public Object[][] excelData() throws Exception {
		Object[][] values = utils.DataProviderObject.getValue(excelFileName);
		return values;
	}

	@Override
	public String takeScreenshot() {
		// TODO Auto-generated method stub
		return null;
	}
		

}
