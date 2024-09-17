package basics;

import java.time.Duration;
import java.util.List;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartAutosuggestion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@class='Pke_EE']")).sendKeys("Smart TV");
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='_3NorZ0 _3jeYYh']//ul//li[1]")));
		
		List<WebElement> suggestions  = driver.findElements(By.xpath("//div[@class='_3NorZ0 _3jeYYh']//ul//li/div"));
		
		System.out.println("No of suggestion :"+ suggestions.size());
		
		for(int i=0;i<suggestions.size();i++)
		{
			System.out.println(suggestions.get(i).getText());
		}

	}

}
