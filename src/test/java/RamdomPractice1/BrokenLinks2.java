package RamdomPractice1;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.flipkart.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		int noOfBrokenlinks =0 ;
		
		for(WebElement linkele : links)
		{
			String hrefAttVal = linkele.getDomAttribute("href");
			
			if(hrefAttVal==null || hrefAttVal.isEmpty())
			{
				System.out.println(hrefAttVal+ "=====>value is null or empty");
				continue;
			}
			
			try {
			   URL linkUrl = new URL(hrefAttVal);
			   
			   HttpURLConnection conn = (HttpURLConnection)linkUrl.openConnection();
			   conn.connect();
			   
			   if(conn.getResponseCode()>=400)
			   {
				   System.out.println(hrefAttVal+"=====>link is broken");
				   noOfBrokenlinks++;
			   }
			   
			   else {
				   
				   System.out.println(hrefAttVal+"=====>link is not broken");
			   }
			}
			catch(Exception e)
			{
				}
			}
		
		System.out.println("Total broken links===>"+ noOfBrokenlinks );
		}
	}

 
