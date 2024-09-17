package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HandleSelectDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		WebElement drpCountry =driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpdwn = new Select(drpCountry);
		
		// By using selecting an option from dropdown 
		//drpdwn.selectByVisibleText("Japan");
		//drpdwn.selectByValue("france");
		//drpdwn.selectByIndex(3);
		
		// step 2 : Find finding all options inn dropdown
		
		List<WebElement> options= drpdwn.getOptions();
		
		System.out.println("Total number of options :"+options.size());
		
		// Print options in console
		
		/*for(int i=0;i<options.size();i++)
		{
		  System.out.println(options.get(i).getText());	
		}*/
		
		//---Enhanced for loop
		
		for(WebElement op : options)
		{
			System.out.println(op.getText());
		}			
		
		Thread.sleep(5000);
		
		driver.close();
		
	}

}
