package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class PracticeDropDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.get("https://practice.expandtesting.com/dropdown");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,250)");
		
		/***************************
		//  with out using Select class
		driver.findElement(By.id("country")).click();
		
		List<WebElement> allCountry = driver.findElements(By.xpath("//select[@id ='country']//option"));
		
		for(int i=0;i<allCountry.size();i++)
		{
			if(allCountry.get(i).getText().equalsIgnoreCase("India"))
			{
				allCountry.get(i).click();
			}
		}
		***************************************************************/
		
		WebElement listbox = driver.findElement(By.id("country"));
		
		Select sel = new Select(listbox);
		
		List<WebElement>  drpList = sel.getOptions();
		
		for(int i=0;i<drpList.size();i++)
		{
			if(drpList.get(i).getText().equalsIgnoreCase("India"))
			{
				drpList.get(i).click();
			}
		}
		
		driver.findElement(By.xpath("//h4[contains(text(),'Rest API')]")).click();
	}

}
