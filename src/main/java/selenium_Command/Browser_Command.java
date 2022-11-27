package selenium_Command;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Command {

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
	public void gebrowserCommand() throws InterruptedException {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.getTitle();
	System.out.println("First browser"+driver.getTitle());
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
	driver.getTitle();
	System.out.println("Second browser" +driver.getTitle());
		
		
		
	}
	
	//@Test(priority=2)
	public void getStatusradiobutton() {
	
		
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
