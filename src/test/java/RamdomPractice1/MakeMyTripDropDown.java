package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.makemytrip.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//span[@class='commonModal__close']")).click();
		
		Thread.sleep(2000);
		Actions act =  new Actions(driver);
		
		driver.findElement(By.xpath("//input[@id='fromCity']")).click();
		
		//act.moveToElement(from).click().build().perform();
		
		
		List<WebElement> ele =  driver.findElements(By.xpath("//div[@id='react-autowhatever-1']//ul//li//div[@class='makeFlex column flexOne appendRight10']/p"));
		
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("Bangkok, Thailand"))
			{
				ele.get(i).click();
				break;
			}
		}
	}

}
