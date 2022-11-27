package selenium_Command;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_HandleBYSelenium {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void HandleDropDown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void getDrowdown1() {
		driver.get("https://www.selenium.dev/selenium/docs/api/java/index.html?overview-summary.html");
		//driver.switchTo().frame(0);\
		driver.switchTo().frame("packageListFrame");
		driver.findElement(By.xpath(" //body/main[1]/ul[1]/li[1]/a[1]")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("packageFrame");
		driver.findElement(By.linkText("WebDriver")).click();
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("classFrame");
		driver.findElement(By.xpath("//body[1]/header[1]/nav[1]/div[1]/div[1]/ul[1]/li[6]/a[1]")).click();
		
		
	}
	

}
