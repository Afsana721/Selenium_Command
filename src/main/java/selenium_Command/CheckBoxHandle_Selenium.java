package selenium_Command;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxHandle_Selenium {
	
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
 		//driver.close();
 	}
	
	@Test
	public void actionOnCheckbxes() throws InterruptedException {
		driver.get("https://itera-qa.azurewebsites.net/home/automation");
		//driver.findElement(By.xpath("//input[@id='monday']")).click();
		//driver.findElement(By.xpath("//input[@id='tuesday']")).click();
	List<WebElement> allchbxes=driver.findElements
			(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
	System.out.println("Total Number Of Chbxes :"+allchbxes.size());

//for each loop / enhance for loop
	
		/*for(WebElement allches:allchbxes) {
			allches.click();
		}*/

//for loop 
	
		/*for(int i=0;i<allchbxes.size();i++) {
			allchbxes.get(i).click();
		}*/
		
// Select last two chbxes: 
		
		//for(int i=allchbxes.size(); i>allchbxes.size(); i--)
		/*for(int i=5;i<allchbxes.size(); i++)
		{
			allchbxes.get(i).click();
		}*/
// select first two chbxes
		/*for(int i=0;i<allchbxes.size()-5; i++)
		{
			allchbxes.get(i).click();
		}*/
	
	
		/*for(int i=0; i<2; i++)
		{
			if(i<2) {
			allchbxes.get(i).click();
			}
		}*/
		
//after selecting then unselecting all of them
	
		/*for(int i=0;i<allchbxes.size();i++) {
		allchbxes.get(i).click();
		}
		
		Thread.sleep(2000);
		for(int i=0;i<allchbxes.size();i++) {
			allchbxes.get(i).click();
			}*/
	
//selected 3 checkbxes but want to unselected all of them with selected chbxes
	
	for(int i=0;i<3;i++) {
		allchbxes.get(i).click();
		}
		
		Thread.sleep(2000);
		for(int i=0;i<allchbxes.size();i++) {
			if(allchbxes.get(i).isSelected())
			{
			allchbxes.get(i).click();
			}
			}
	}

}
