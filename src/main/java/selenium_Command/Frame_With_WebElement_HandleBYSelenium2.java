package selenium_Command;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frame_With_WebElement_HandleBYSelenium2 {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void HandleDropDown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void getDrowdown1() {
	driver.get("https://ui.vision/demo/webtest/frames/");
	WebElement frm1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
	driver.switchTo().frame(frm1);
	driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Asef Khan");
	driver.switchTo().defaultContent();
	
	WebElement frm3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
	driver.switchTo().frame(frm3);
	driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Masud Kahan");
//Inner frame on Frame3
	driver.switchTo().frame(0);
	driver.findElement(By.cssSelector(".AB7Lab")).click();
		
	}
	

}
