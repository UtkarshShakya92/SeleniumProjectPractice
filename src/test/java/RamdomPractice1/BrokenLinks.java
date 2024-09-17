package RamdomPractice1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demowebshop.tricentis.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		int noOfBrokenLinks =0;
		for(WebElement linkelement:allLinks)
		{
			
			String hrefAttValue = linkelement.getAttribute("href");
			
			if(hrefAttValue == null || hrefAttValue.isEmpty())
			{
				System.out.println(hrefAttValue+ ": ==>is empty or null ");
				continue;
			}
			
			try {
				//converting string to url format
			URL link = new URL(hrefAttValue);
			
			//opening the connection 
			HttpURLConnection conn = (HttpURLConnection) link.openConnection();
			
			conn.connect();
			
			if(conn.getResponseCode()>=400)
			{
				System.out.println(hrefAttValue +"====> is a broken link");
				noOfBrokenLinks ++;
			}
			
			else
			{
				System.out.println(hrefAttValue +"====> is not a broken link");
			}
			
			}
			
			catch(Exception e)
			{
				
			}
			
		}
		System.out.println("No of broken links :"+ noOfBrokenLinks);

}
}