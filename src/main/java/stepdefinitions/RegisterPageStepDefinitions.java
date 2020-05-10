package stepdefinitions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class RegisterPageStepDefinitions {
	
	WebDriver driver ;
	Properties prop;
	FileInputStream fin;
	@Given("^user is on start page$")
	public void user_is_on_start_page() throws IOException {
		System.setProperty("webdriver.gecko.driver", "F:\\Downloads Softwares\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		prop = new Properties();
		prop.load(fin);
		
		
		driver.get(prop.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	 
	}

	@When("^user clicks on sign up link$")
	public void user_clicks_on_sign_up_link() {
		
		WebElement signUp = driver.findElement(By.xpath("//a[text()='Sign Up']"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(signUp));
		
		signUp.click();
		
		
		
	}

	
	@Then("^user is navigated to register page$")
	public void user_is_navigated_to_register_page() {
	  
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		Assert.assertEquals("https://register.freecrm.com/register/", driver.getCurrentUrl());
		
	}

	@Then("^window is closed$")
	public void window_is_closed() {
	    
		driver.quit();
	}


}
