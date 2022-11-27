package selenium_Command;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_ForSign_in_Application {
	
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
		
	//http://admin:admin@	
		
	driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
		
	String act_text =driver.findElement(By.xpath("//p[contains(text(),'Congratulations')]")).getText();
	
	if(act_text.contains("Congratulations! You must have the proper credentials.")) {
		System.out.println("Successful Loged in");
	}else
	{
		System.out.println("Login Failed");
	}
		
		
	}
	

}
