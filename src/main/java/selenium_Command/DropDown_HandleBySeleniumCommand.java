package selenium_Command;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDown_HandleBySeleniumCommand {
	
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
	public void getDrowdown1() {
		driver.get("https://www.opencart.com/index.php?route=account/register");
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-black navbar-btn')]")).click();
	WebElement dropElement =driver.findElement(By.xpath("//select[@id='input-country']"));
		
		Select drop = new Select(dropElement);
		//drop.selectByIndex(18);
		//drop.selectByVisibleText("Bangladesh");
		drop.selectByValue("96");
		
		List<WebElement>options =drop.getOptions();
		System.out.println("total number of options : "+options.size());
		
		/*for(int i=0; i<options.size();i++)
		{
			options.get(i).getText();
			System.out.println(options.get(i).getText());
		}*/
		
//For each loop / enhance
		
		for(WebElement opt:options)
		{
			opt.getText();
			System.out.println(opt.getText());
		}
	}
	

}
