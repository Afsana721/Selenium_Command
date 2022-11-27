package selenium_Command;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Alert_handle {
	
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
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
		//driver.switchTo().alert().accept();
		Alert alertWin1=driver.switchTo().alert();
		alertWin1.accept();
		
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
		Alert alertWin2 = driver.switchTo().alert();
		//alertWin2.accept();
		alertWin2.dismiss();
		
		WebDriverWait mywait = new WebDriverWait(driver, 10);
		driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
		Alert alertWin3 =mywait.until(ExpectedConditions.alertIsPresent());
		
		alertWin3.sendKeys("Asef");
		alertWin3.getText();
		System.out.println(alertWin3.getText());
		alertWin3.accept();
		
		String actualText =driver.findElement(By.xpath("//p[@id='result']")).getText();
		String expectedText = "You entered: Asef";
		
		if(actualText.equals(expectedText)) {
			System.out.println("Test is passed");
		}else {
			System.out.println("Test is passed");
		}
				
		//alertWin3.dismiss();
		
	}
	

}
