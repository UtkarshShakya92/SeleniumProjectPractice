package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class ParamDemo {
 
	WebDriver driver;
  @BeforeClass
  @Parameters({"browser","url"})
  public void setup(String br,String appurl) throws InterruptedException {
	  
	  /*
	  if(br.equals("chrome"))
	  {
	  driver=new ChromeDriver();
	  }
	  
	  else if(br.equals("edge"))
	  {
		  driver=new EdgeDriver();
	  }
	  
	  else
	  {
		 System.out.println("invalid browser");
		
	  }
	  */
	  
	  
	  switch(br.toLowerCase())
	  {
	  case "chrome": driver=new ChromeDriver(); break;
	  case "edge" : driver=new EdgeDriver(); break;
	  case "firefox" : driver = new FirefoxDriver(); break;
	  default : System.out.println("invalid browser"); return;
	  
	  }
	  
	  
	  driver.get(appurl);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  Thread.sleep(5000);
  }

  @Test(priority=1)
  public void logo() {
	 
	 try {
	 boolean status = driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
	 Assert.assertEquals(status, true);
	 }
	 
	 catch(Exception e)
	 {
		Assert.fail(); 
	 }
	 
  }
  
  @Test(priority=2)
  public void HomeTitle() {
	  Assert.assertEquals(driver.getTitle(),"OrangeHRM","The titles are not matched");
  }
  @AfterClass
  public void teardown() {
	  driver.quit();
  }

}
