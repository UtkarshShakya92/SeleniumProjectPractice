package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectionUsage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://freelance-learn-automation.vercel.app/signup");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		List<WebElement> allElements = driver.findElements(By.xpath("//input[@type='checkbox']"));
		
		//allElements.get(2).click();
		
		for(int i=0;i<allElements.size();i++)
		{
			//allElements.get(i).click();
			allElements.get(i+(i+1)).click();
		}
		
		
	}

}
