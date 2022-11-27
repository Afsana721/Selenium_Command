package selenium_Command;




import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Wait_Command {
	
public WebDriver driver;

 	@BeforeMethod
 	public void setup() {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
 	}
	
	@AfterMethod
 	public void tearDown() {
 		driver.close();
 	}
	
	
 	//@Test(priority=1)
 	public void getimplicitWaitStatement() {
 		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 		
 		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
 		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
 		driver.findElement(By.xpath("//button[@type='submit']")).click();
 		driver.getTitle();
 		System.out.println("Page Title is  : "+driver.getTitle());
 	}
 	
 	@Test(priority=1)
 	public void getExplicitWaitStatement() {
 		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
 		
 		WebDriverWait wait=new WebDriverWait(driver, 10);
 		
 		WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
 		username.sendKeys("Admin");
 		
 		//driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
 		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
 		driver.findElement(By.xpath("//button[@type='submit']")).click();
 		driver.getTitle();
 		System.out.println("Page Title is  : "+driver.getTitle());
 		
 	}
 

}
