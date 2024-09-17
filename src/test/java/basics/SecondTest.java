package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SecondTest {
	
	WebDriver driver;
	
	//@BeforeClass
  @Test(priority=1)
  public void OpenApp() {
	  
	  driver = new ChromeDriver();
	  
	  driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  
  }
  @Test(priority=2)
  public void Login()
  {
	  driver.findElement(By.name("username")).sendKeys("Admin");
	  
	  driver.findElement(By.name("password")).sendKeys("admin123");
	  
	  driver.findElement(By.xpath("//button[.=' Login ']")).click();
	  }
  
  //@AfterClass 
 @Test(priority=3)
  public void CloseApp()
  {
	  driver.close();
  }
}
