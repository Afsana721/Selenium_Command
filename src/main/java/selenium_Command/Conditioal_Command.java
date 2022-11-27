package selenium_Command;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Conditioal_Command {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	
	@Test(priority=1)
	public void getWebElementStatus() {
		driver.get("https://demo.nopcommerce.com/register");
		
		boolean imagLogo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//WebElement imagLogo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//boolean statusOfLogo=imagLogo.isDisplayed();
		//System.out.println("Display status of Logo is : "+statusOfLogo);
		System.out.println("Display status of Logo is : "+imagLogo);
		
		WebElement inputbx=driver.findElement(By.xpath("//input[@id='small-searchterms']"));
					inputbx.isDisplayed();
					inputbx.isEnabled();
		
		System.out.println("Search Box Current Status is displayed "+ inputbx.isDisplayed()+ ": AND :"+" nex status is enabled  "+ inputbx.isEnabled());
	}
	
	@Test(priority=2)
	public void getStatusradiobutton() {
	driver.get("https://demo.nopcommerce.com/register");
		
	WebElement male_rd =driver.findElement(By.xpath("//input[@id='gender-male']"));
	WebElement female_rd =driver.findElement(By.xpath("//input[@id='gender-female']"));
		
	System.out.println("Status of Radio Button  :" +male_rd.isSelected() +":And :" +female_rd.isSelected());
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
