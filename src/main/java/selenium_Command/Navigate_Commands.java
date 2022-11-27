package selenium_Command;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Navigate_Commands {
	
	public WebDriver driver;
	
	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void navigationalCommand() {
		driver.get("https://www.amazon.in/");
		System.out.println("Amazon Url: "+driver.getCurrentUrl());
		
		driver.get("https://www.flipkart.com");
		System.out.println("Flipkart Url: "+driver.getCurrentUrl());
		
		driver.navigate().back();
		System.out.println("Amazon URL: "+driver.getCurrentUrl());
		
		driver.navigate().forward();
		System.out.println("Fliphart Url: "+driver.getCurrentUrl());
		
		driver.navigate().refresh();
		
	}

}
