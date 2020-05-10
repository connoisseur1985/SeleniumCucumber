package stepdefinitions;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class LoginPageStepDefinitions {
	
	WebDriver driver;
	FileInputStream fin;
	Properties prop;
	@Given("^crmpro Login Page is opened$")
	public void crmpro_Login_Page_is_opened() throws IOException 
	{
		System.setProperty("webdriver.chrome.silentOutput", "true");
		System.setProperty("webdriver.chrome.driver","F:\\Downloads Softwares\\chromedriver.exe");
		driver = new ChromeDriver();
		
		
		fin = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\config\\config.properties");
		prop = new Properties();
		prop.load(fin);
		
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	@When("^UserName and Password is entered$")
	public void UserName_and_Password_is_entered() 
	{
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		WebElement login = driver.findElement(By.xpath("//div[text()='Login']"));
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(login));
		
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		
	}
	
	@And("^Login Button is clicked$")
	public void Login_Button_is_clicked() {
		
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		

	}
	
	@Then("^HomePage Opens$")
	public void HomePage_Opens() {
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Ankur Mahajan']"))));
	
	Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Ankur Mahajan']")).isDisplayed());
	}
	
	@Then("^Browser is closed$")
	public void Browser_is_closed() {
		driver.quit();
	}
	
}
