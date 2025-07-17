package factory;

public class BrowserFactoryManager {
	
	public static FactoryInterface getDriver(String browserType) {
		switch (browserType.toLowerCase()) {
		case "chrome":
			return new ChromeDriverManager();
		case "edge":
			return new EdgeDriverManager();
		default:
			throw new IllegalArgumentException("Browser Type is not valid");
		}
	}

}
