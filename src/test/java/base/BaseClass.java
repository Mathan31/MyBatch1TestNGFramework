package base;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
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
	public String testName,testDescription,testModule;
	
	@BeforeSuite
	public void reportInit() {
		startReport();
	}
	
	@AfterSuite
	public void bindReport() {
		endReport();
	}
	
	@BeforeClass
	public  void invokeBrowser() {
		driver = BrowserFactoryManager.getDriver(browserType).driverManager();
		driver.manage().window().maximize();
		driver.navigate().to(sURL);
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		startTestCase(testName, testDescription);
		startTestCase(testModule);
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
		String sPath = System.getProperty("user.dir")+"/snap/img"+System.currentTimeMillis()+".png";
		TakesScreenshot oShot = (TakesScreenshot)driver;
		File osrc = oShot.getScreenshotAs(OutputType.FILE);
		File dis = new File(sPath);
		try {
			FileUtils.copyFile(osrc, dis); 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sPath;
	}
		

}
