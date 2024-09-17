package testng;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class DataProviders {
	
	WebDriver driver;
	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	
  @Test(dataProvider ="dp")
  public void login(String email, String pwd) {
	  driver.get("https://demo.nopcommerce.com/login");
	  
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	  driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Password")).sendKeys(pwd);
		driver.findElement(By.xpath("//button[.='Log in']")).click();

		String exp_title = "nopCommerce demo store";
		String act_title = driver.getTitle();

		Assert.assertEquals(exp_title, act_title);
  }
  
  @AfterClass
       void teardown()
       {
	      driver.close();
       }
  
  @DataProvider(name="dp")
      String[][] loginData()
       {
	  String data[][]= {  
				{ "abc@gmail.com", "test123" }, 
				{ "pavanol@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test3" },
				{ "pavanoltraining@gmail.com", "test@123" },
				{ "pavanoltraining@gmail.com", "test@123" } 
			};

             return data;
       }
}
