package Page_Object_Model;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AmazonAutoSuggestMain {
	
	WebDriver driver;
	@BeforeTest
	
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test
	public void autoSuggest()
	{
		Amazonsuggloc as = new Amazonsuggloc(driver);
		
         System.out.println("no of suggestions : "+as.options.size());
		
		for(int i=0;i<as.options.size();i++)
		{
			System.out.println(as.options.get(i).getText());
		}
		
	}
	
	@AfterTest
	
	void teardown()
	{
		driver.quit();
	}
}
