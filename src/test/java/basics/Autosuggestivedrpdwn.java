package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Autosuggestivedrpdwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Smart TV");
		
		List<WebElement> options =driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']"));
		//w.until(ExpectedConditions.visibilityOfAllElements(options));
		
	     
		System.out.println("no of suggestions : "+options.size());
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		driver.quit();
	}
	
}
