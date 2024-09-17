package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		//Declare ExplicitlyWait
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//usage of explicitlywait --- Condition to wait 
		
		WebElement username =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")));
		username.sendKeys("admin");
		
		WebElement pass =mywait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")));
		pass.sendKeys("admin123");
		//driver.findElement(By.name("username")).sendKeys("admin");
		
		//driver.findElement(By.name("password")).sendKeys("admin123");
	}

}
