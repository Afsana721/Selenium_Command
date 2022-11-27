package selenium_Command;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Get_Methods {
	
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
	public void getSeleniumMethods() {
		driver.get("https://www.google.com");
		
		String actual =driver.getTitle();
		
		System.out.println(actual);
		if(driver.getTitle().equals("Google")) {
			Assert.assertTrue(true);
			System.out.println("Test is passed");
		}else {
			System.out.println("Test is failed");
		}
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Selenium",Keys.ENTER);
		
		String currentTitle =driver.getCurrentUrl();
		
		System.out.println(currentTitle);
		driver.navigate().back();
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Java",Keys.ENTER);
		
		String nTitle=driver.getTitle();
		System.out.println(nTitle);
		
		if(nTitle.equals("Java - Google Search")) {
			Assert.assertTrue(true);
			System.out.println("Test is passed again");
		}else {
			System.out.println("Test is failed again");
		}
		
		String pagesource =driver.getPageSource();
	}
	
	@Test(priority=2)
	public void getHandlewindow() {
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();
		String orangeTitle= driver.getTitle();
		System.out.println(orangeTitle);
		
		String singleWin=driver.getWindowHandle();
		
		Set<String> allWins = driver.getWindowHandles();
		
		for(String winid:allWins) {
			System.out.println("windowids are : "+winid);
		}
		System.out.println(singleWin);
		//System.out.println(allWins);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
