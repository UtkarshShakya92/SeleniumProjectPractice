package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleAutoDrop {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.get("https://www.google.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.cssSelector("textarea#APjFqb")).sendKeys("Selenium");
		
		List<WebElement> options = driver.findElements(By.xpath("//div[@id='Alh6id']//ul[@role='listbox']//li"));
		
		System.out.println(options.size());
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
			
			if(options.get(i).getText().equalsIgnoreCase("Selenium WebDriver"))
			{
				options.get(i).click();
				break;
				
			}	
			
		}
			

	}
}