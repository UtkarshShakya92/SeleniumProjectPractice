package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleDropDown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.name("q")).sendKeys("Selenium");
		
		Thread.sleep(2000);
		
		List<WebElement> list= driver.findElements(By.xpath("//div[@role='presentation']//ul//li"));
		
		int count = list.size();
		
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
			
			String req= list.get(i).getText();
			if(req.equalsIgnoreCase("Selenium"))
			{
				list.get(i).click();
				break;
			}
		}
		
		//driver.close();
		
	}

}
