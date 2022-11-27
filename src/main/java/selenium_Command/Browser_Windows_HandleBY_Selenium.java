package selenium_Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser_Windows_HandleBY_Selenium {

	public WebDriver driver;

	@BeforeMethod
	public void setup() {
		
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	}
	
	//@AfterMethod
		public void tearDown() {
			driver.quit();
		}
	
	@Test(priority=1)
	public void gebrowserCommand() throws InterruptedException {
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	driver.findElement(By.xpath("//a[contains(.,'OrangeHRM, Inc')]")).click();
	
	Set<String>winids= driver.getWindowHandles();
	/*List<String> windowslist= new ArrayList<String>(winids);
	String parentWinID=windowslist.get(0);
	String childWinID = windowslist.get(1);
	
	driver.switchTo().window(childWinID);
	driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
	driver.getTitle();
	System.out.println(driver.getTitle());
	driver.switchTo().window(parentWinID);
	driver.getTitle();
	System.out.println(driver.getTitle());
	driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");*/
	
// Switching to another window to do some actions
	/*for(String winid:winids) {
		
		String title =driver.switchTo().window(winid).getTitle();
		if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
		{
			driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//li[1]//a[1]")).click();
		}
		
	}*/

//Closing specific browser windows based on our choice
	
	for(String winid:winids) {
		
		String title =driver.switchTo().window(winid).getTitle();
		//if(title.equals("OrangeHRM") || title.equals("") ||title.equals(""))
		
		//if(title.equals("OrangeHRM"))
		if(title.equals("OrangeHRM HR Software | Free & Open Source HR Software | HRMS | HRIS | OrangeHRM"))
		{
			driver.close();
		}
		
	}
	
		
		
	}
	
	
	
	
	
}
