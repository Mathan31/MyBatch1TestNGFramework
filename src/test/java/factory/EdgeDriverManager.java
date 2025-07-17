package factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class EdgeDriverManager implements FactoryInterface{

	@Override
	public WebDriver driverManager() {
		// TODO Auto-generated method stub
		return new EdgeDriver();
	}

}
