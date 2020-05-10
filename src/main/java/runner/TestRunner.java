package runner;



import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
					features= {"C:\\Users\\ASUS\\eclipse-workspace\\CucumberSeleniumTest\\src\\main\\java\\features\\AddContacts.feature","C:\\Users\\ASUS\\eclipse-workspace\\CucumberSeleniumTest\\src\\main\\java\\features\\LoginPage.feature"},
					glue = {"stepdefinitions"},
					plugin = {"pretty","html:test-output","json:json-output/cucumber.json","junit:junit-output/cucumber.xml"},
					dryRun= false,
					monochrome=true,
					strict=true
				)

public class TestRunner {

}
