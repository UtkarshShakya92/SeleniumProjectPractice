package RamdomPractice1;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		 
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		
		String[] itemsNeeded = {"Cucumber","Brocolli","Beetroot"};
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> products=driver.findElements(By.xpath("//h4[@class='product-name']"));
		
		//Thread.sleep(3000);
		
		int j =0;
		
		for(int i=0;i<products.size();i++)
		{
			
			//Brocolli - 1 Kg

			//Brocolli,    1 kg
			
			String[] itemName = products.get(i).getText().split("-");
			String formattedItemName =itemName[0].trim();
			
			//format it to get actual vegetable name

			//convert array into array list for easy search

			//  check whether name you extracted is present in arrayList or not-
			
			List itemNeedList = Arrays.asList(itemsNeeded);
			
			if(itemNeedList.contains(formattedItemName))
			{
				j++;
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==itemsNeeded.length)
				{
					break;
				}
			}
		}

	}

}
