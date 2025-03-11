package webTables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.openqa.selenium.support.locators.RelativeLocator.*;
public class WebTablehandleMukesh {
	
	//headings and colms---> //table[contains(@id,'custom')]//th
	
	//rows including heading row ---> //table[contains(@id,'custom')]//tr
			
	//alldata --> //table[contains(@id,'custom')]//td
			
	//only second col data --> //table[contains(@id,'custom')]//td[2]
			
	//only 4th col data  --> //table[contains(@id,'custom')]//td[4]

	@Test
	public void webTable() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("http://seleniumpractise.blogspot.com/");
		
		//headers
		
		List<WebElement> allHeaders =driver.findElements(By.xpath("//table[contains(@id,'custom')]//th"));
		
		System.out.println(allHeaders.size());
		
		Assert.assertEquals(allHeaders.size(), 5,"Coloum count are not matching");
		
		boolean status = false;
		
		for(WebElement ele: allHeaders)
		{
			String value = ele.getText();
			
			System.out.println(value);
			
			if(value.contains("Country"))
			{
				status = true;
				break;
			}
		}
		
		Assert.assertTrue(status,"Header is not present");
		System.out.println("===============================");
		
		List<WebElement> allrows = driver.findElements(By.xpath("//table[contains(@id,'custom')]//tr"));
		System.out.println(allrows.size());
		
		Assert.assertEquals(allrows.size(), 7,"Rows mismatch");
		
		System.out.println("===============================");
		
		List<WebElement> alldata = driver.findElements(By.xpath("//table[contains(@id,'custom')]//td"));
		System.out.println(alldata.size());
		
		boolean datastatus = false;
		
		for(WebElement data: alldata )
		{
			String datavalue = data.getText();
			
			System.out.println(datavalue);
			
			if(datavalue.contains("Java"))
			{
				datastatus = true;
				break;
			}
		}
		
		Assert.assertTrue(datastatus, "Record is not present");
		
		//selenium checkbox click
		driver.findElement(By.xpath("//table//td[text()='Selenium']//preceding-sibling::td/input")).click();
		
		Thread.sleep(2000);
		//Java knw more link click
		
		//driver.findElement(By.xpath("//table//td[text()='Java']//following-sibling::td[3]//a")).click();
		
		WebElement california =driver.findElement(By.xpath("//table//td[text()='California ']"));
		
		driver.findElement(with(By.tagName("a")).toRightOf(california)).click();
		
		//driver.close();
	}
}
