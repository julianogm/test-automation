package runner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import drivers.DriverWeb;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/", 
		tags = "@api", 
		glue = "steps", 
		plugin = { "summary","pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports" },
		monochrome = true
		)

public class Runner {

	@BeforeClass
	public static void setConfig() {
		DriverWeb.setChromeDriver();
	}
	
	@AfterClass
	public static void closeBrowser() {
		DriverWeb.finishDriver();
	}
}