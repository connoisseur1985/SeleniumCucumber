package stepdefinitions;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddContactsStepDefinitions {

	WebDriver driver;
	FileInputStream fin;
	Properties prop;
	WebDriverWait wait;
	
	@Given("^user is on home page$")
	public void user_is_on_home_page() throws Throwable {
	  
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
		driver.findElement(By.xpath("//span[contains(text(),'Log In')]")).click();
		
		WebElement login = driver.findElement(By.xpath("//div[text()='Login']"));
		wait = new WebDriverWait(driver,20);
		
		
		wait.until(ExpectedConditions.visibilityOf(login));
		
		driver.findElement(By.name("email")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.name("password")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//div[text()='Login']")).click();

		wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[text()='Ankur Mahajan']"))));
		
		Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Ankur Mahajan']")).isDisplayed());
		
	}

	@When("^user clicks on cantacts link$")
	public void user_clicks_on_cantacts_link() throws Throwable {
	    
		driver.findElement(By.xpath("//span[text()='Contacts']")).click();
		driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Then("^user clicks on new button$")
	public void user_clicks_on_new_button() throws Throwable {
		
		Thread.sleep(6000);

	driver.findElement(By.xpath("//button[@class='ui linkedin button']/i[@class='edit icon']")).click();
	driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@Then("^user enters credentials$")
	public void user_enters_credentials() throws Throwable {
	    
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		Robot robot = new Robot();
//		WebElement name = driver.findElement(By.xpath("//input[@name='first_name']"));
//		
//		WebDriverWait wait = new WebDriverWait(driver,20);
//		wait.until(ExpectedConditions.visibilityOf(name));
//		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@name='first_name']")));
//		js.executeScript("arguments[0].value='Ankur';",driver.findElement(By.xpath("//input[@name='first_name']")));
//		
//		JavascriptExecutor js1 = (JavascriptExecutor)driver;
//		js1.executeScript("arguments[0].click();",driver.findElement(By.xpath("//input[@name='last_name']")));
//		js1.executeScript("arguments[0].value='Mahajan';",driver.findElement(By.xpath("//input[@name='last_name']")));
//		Thread.sleep(2000);
		driver.findElement(By.name("first_name")).sendKeys("Ankur");
		driver.findElement(By.name("last_name")).sendKeys("Mahajan");
//		
		driver.findElement(By.xpath("//div[@name='company']/input")).click();
		
		JavascriptExecutor js2 = (JavascriptExecutor)driver;
		js2.executeScript("arguments[0].value='Infy';",driver.findElement(By.xpath("//div[@name='company']/input")));
		
		Thread.sleep(3000);
		
		robot.keyPress(KeyEvent.VK_ENTER);
		
		
		
		//driver.findElement(By.xpath("//div[@name='company']/input")).sendKeys("Infy");
		//driver.findElement(By.xpath("//i[@class='unlock icon']")).click();
		//driver.findElement(By.xpath("//div[@class='twelve wide field']/div[@role='listbox']/i[@class='dropdown icon']")).click();
		//driver.findElement(By.xpath("//div[@role='listbox' and @class='visible menu transition']/div/span[text()='Infy']")).click();
		Thread.sleep(3000);
		//js.executeScript("document.getElementByXpath('//div[@role='combobox' and @class='ui fluid multiple search selection dropdown']').value='Engineer';");
		driver.findElement(By.xpath("//button[@class='ui small fluid positive toggle button']")).click();
		JavascriptExecutor js3 = (JavascriptExecutor)driver;
		//js2.executeScript("arguments[0].click();", driver.findElement(By.xpath("//label[@for='tags']/div" )));
		
		js3.executeScript("arguments[0].value='Engineer';", driver.findElement(By.xpath("//label[@for='tags']/div" )));
		
		Thread.sleep(3000);
				
		robot.keyPress(KeyEvent.VK_ENTER);
		
		js3.executeScript("arguments[0].value='the.connoisseur1985@gmail.com'",driver.findElement(By.xpath("//input[@name='value']")));
		driver.findElement(By.name("category")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@class='visible menu transition']/div"));
		
		for(WebElement e : list) 
		{
			if(e.getText().equalsIgnoreCase("Lead")) {
				e.click();
				break;
			};
		}
		
		driver.findElement(By.name("status")).click();
		List<WebElement> listStatus = driver.findElements(By.xpath("//div[@class='visible menu transition']/div"));
		for(WebElement e : listStatus) 
		{
			if(e.getText().equalsIgnoreCase("Hot")) 
			{
				e.click();
				break;
			}
		}
		
		
		driver.findElement(By.name("description")).sendKeys("He is quite hot!!!");
		
		driver.findElement(By.name("channel_type")).click();
		List<WebElement> listSocial = driver.findElements(By.xpath("//div[@class='visible menu transition']/div"));
		Iterator<WebElement> it = listSocial.iterator();
		while(it.hasNext()) 
		{
			WebElement w = it.next();
			if(w.getText().equalsIgnoreCase("LinkedIn")) {
				w.click();
				break;
			}
		}
		
		driver.findElement(By.cssSelector("input[name='value']")).sendKeys("abcdef");
		
		driver.findElement(By.xpath("//input[@placeholder='LinkedIn profile link']")).click();
		driver.findElement(By.xpath("//input[@placeholder='LinkedIn profile link']/parent::div/following-sibling::button")).click();
		driver.findElement(By.xpath("//label[text()='Social Channels']/parent::div/div/div[2]/div[@name='channel_type']")).click();
		
		List<WebElement> listSoc = driver.findElements(By.xpath("//label[text()='Social Channels']/parent::div/div/div[2]/div[@name='channel_type']/i/following-sibling::div/div"));
		for(WebElement w : listSoc) 
		{
			if(w.getText().equalsIgnoreCase("FaceBook")) 
			{
				w.click();
				break;
			}
		}
	
		driver.findElement(By.cssSelector("div[name='timezone']")).click();
		
		List<WebElement> listCountry = driver.findElements(By.xpath("//div[@name='timezone']/i/following-sibling::div/div"));
		for(WebElement w : listCountry) 
		{
			if(w.getText().equalsIgnoreCase("Asia/Dili")) 
			{
				w.click();
				break;
			}
		}
	
		js.executeScript("window.scrollBy(0,800);", "");
		
		driver.findElement(By.name("address")).sendKeys("Abcdef Road");
		driver.findElement(By.name("city")).sendKeys("Brampton");
		driver.findElement(By.name("state")).sendKeys("Punjab");
		driver.findElement(By.name("zip")).sendKeys("143001");
		driver.findElement(By.name("country")).click();
		List<WebElement> listCountries = driver.findElements(By.xpath("//div[@name='country']/i/following-sibling::div/div"));
		for(WebElement w : listCountries) 
		{
			if(w.getText().equalsIgnoreCase("Canada")) 
			{
				w.click();
				break;
			}
		}
		
		
		driver.findElement(By.name("hint")).click();
		List<WebElement> li = driver.findElements(By.xpath("//div[@name='hint']/i/following-sibling::div/div"));
		for(WebElement w : li) 
		{
			if(w.getText().equalsIgnoreCase("Canada")) 
			{
				w.click();
				break;
			}
		}
		
		driver.findElement(By.name("source")).click();
		List<WebElement> lis = driver.findElements(By.xpath("//div[@name='source']/i/following-sibling::div/div"));
		for(WebElement w : lis) 
		{
			if(w.getText().equalsIgnoreCase("Google")) 
			{
				w.click();
				break;
			}
		}
		
		WebElement w1 = driver.findElement(By.xpath("//input[@name='do_not_call']"));
		js.executeScript("arguments[0].click();", w1);
		
		
		driver.findElement(By.name("day")).sendKeys("15");
		driver.findElement(By.name("month")).click();
		List<WebElement> listi = driver.findElements(By.xpath("//div[@name='month']/i/following-sibling::div/div"));
		for(WebElement w : listi) 
		{
			if(w.getText().equalsIgnoreCase("February")) 
			{
				w.click();
				break;
			}
		}
		
		driver.findElement(By.name("year")).sendKeys("1985");
		
		driver.findElement(By.id("onesignal-bell-launcher")).click();
		
	
	
		
	}  

	@Then("^user clicks on save button$")
	public void user_clicks_on_save_button() throws Throwable {
	
		driver.findElement(By.xpath("//button[@class='ui linkedin button']")).click();
	}

	@Then("^user closes the browser$")
	public void user_closes_the_browser() throws Throwable {
		
		Thread.sleep(10000);
		driver.quit();
	    
	}

}
