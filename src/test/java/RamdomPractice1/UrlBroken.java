package RamdomPractice1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UrlBroken {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.practicebuilders.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links present :"+ links.size());
		
		int noofbrokenLinks = 0;
		
		// iterate to all the links 
		
		for(WebElement linkElement :links)
		{
			String hrefAttValue = linkElement.getAttribute("href");
			//String hreftext = linkElement.getText();
			// if the href value is null or empty 
			   
			if(hrefAttValue== null && hrefAttValue.isEmpty())
			{
				System.out.println(hrefAttValue+ " this url is empty or null ");
				continue;
			}
			
			//hit url to the server
			
			try 
			{
				//here we will convert href string to url format
				
				URL  linkUrl = new URL(hrefAttValue);
				
				// http open connection to the server
				
			HttpURLConnection conn = (HttpURLConnection)linkUrl.openConnection(); 	
				
				conn.connect();
				
				if(conn.getResponseCode()>=400)
				{
					System.out.println(hrefAttValue +" ==> is broken link");
					
					noofbrokenLinks++;
				}
				
				else 
				{
					System.out.println(hrefAttValue +" ==> is not broken link");
				}
			}
			
			catch(Exception e)
			{
				
			}
		}
		
		System.out.println("No of Broken Links===>"+ noofbrokenLinks);
	}

}
