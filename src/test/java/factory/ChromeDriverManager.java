package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverManager implements FactoryInterface{

	@Override
	public WebDriver driverManager() {
		// TODO Auto-generated method stub
		return new ChromeDriver();
	}

}
