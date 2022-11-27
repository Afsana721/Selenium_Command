package selenium_Command;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownAuto_Suggest_DynamicData {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	public void HandleDropDown() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	//@AfterMethod
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void getDrowdown1() throws InterruptedException {
		driver.get("https://www.google.com");
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("Seleniu");
		Thread.sleep(1000);
		List<WebElement> sugestSelenium =driver.findElements(By.xpath("//div[contains(@class,'wM6W7d')]//span"));
		System.out.println(sugestSelenium.size());
		
		/*for(WebElement sugest:sugestSelenium)
		{
			String sugText=sugest.getText();
			System.out.println(sugText);
		}*/
		
		for(int i=0; i<sugestSelenium.size();i++)
		{
			String texts =sugestSelenium.get(i).getText();
			//System.out.println(texts);
			
			if(texts.equals("selenium webdriver"))
			{
				sugestSelenium.get(i).click();
				driver.getTitle();
				System.out.println(driver.getTitle());
				break;
			}
			
		}
		
	
	}
	

}
