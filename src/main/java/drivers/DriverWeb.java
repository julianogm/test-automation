package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverWeb {
	public static WebDriver driver = null;
	
	public static void setChromeDriver() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	
	public static void finishDriver() {
		if(driver!=null) {
			driver.quit();
			driver = null;
		}
	}
}
