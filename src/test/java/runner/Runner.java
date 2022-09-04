package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/features/", 
		tags = "@tag1", 
		glue = "steps", 
		plugin = { "summary", "pretty", "html:target/cucumber-reports.html", "json:target/cucumber-reports" }, 
		monochrome = true
)

public class Runner {

}