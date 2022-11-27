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

public class DropDown_HandleBy_No_SelectTAG {
	
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
	public void getbootsDropdown() throws InterruptedException {
// here, no Select tag in DOM page for dropdown

		driver.get("https://www.jquery-az.com/boots/demo.php?%20ex=63.0_2");
		driver.findElement(By.xpath("//button[@type='button']")).click();
	List<WebElement> options=driver.findElements
			(By.xpath("//ul[contains(@class,'multiselect')]//label"));
	
	System.out.println("Total Number of Options: "+options.size());
	
	/*for(WebElement opt:options) {
		opt.getText();
		System.out.println(opt.getText());
	}*/
	
	/*for(int i=0; i<options.size(); i++) {
		options.get(0).getText();
		System.out.println(options.get(i).getText());
	}*/

	/*for(int i=0; i<options.size(); i++) {
		
		String option=options.get(i).getText();
		
		if(option.equals("Java") || option.equals("Python") || option.equals("MySQL"))
		{
			options.get(i).click();
			
		}
	}*/
	
	for(WebElement option:options)
	{
		String optionText = option.getText();
		
		//if(option.getText().equals("Java") || option.getText().equals("Python"))
		if(optionText.equals("Java") || optionText.equals("Python"))
		{
			option.click();
		}
	}
		
	}
	

}
