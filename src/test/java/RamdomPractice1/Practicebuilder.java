package RamdomPractice1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practicebuilder {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

   WebDriver driver = new ChromeDriver();
   
    driver.get("https://www.practicebuilders.com/");
    
    driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//driver.findElement(By.xpath("//a[@class='btn']")).click();
	
	WebElement whowehelp = driver.findElement(By.xpath("//div[@class='container']//a[normalize-space(text())='Who We Help']"));
	Actions act = new Actions(driver);
	act.moveToElement(whowehelp).build().perform();
	
	List<WebElement> allLinks =driver.findElements(By.xpath("//ul[@class='dropdown-menu megamenu-full']//a"));
	
	for(WebElement reqlink : allLinks)
	{
		//reqlink.click();
		
		Thread.sleep(3000);
		
		
            String linkUrl = reqlink.getAttribute("href");
            
            // Verify the link is not null or empty
            if (linkUrl != null && !linkUrl.isEmpty()) {
                // Open the link in the same tab
                driver.navigate().to(linkUrl);
                
                // Check if the page loaded correctly (e.g., by checking the title or a specific element)
                String pageTitle = driver.getTitle();
                if (!pageTitle.contains("Error")) {
                    System.out.println("Link is working: " + linkUrl);
                } else {
                    System.out.println("Broken link: " + linkUrl);
                }
                
                Thread.sleep(2000);
                // Navigate back to the original page with tabs
                driver.navigate().back();
                
                
            } else {
                System.out.println("Invalid link found under tab: " );
            }
            
            WebElement whowehelping = driver.findElement(By.xpath("//div[@class='container']//a[normalize-space(text())='Who We Help']"));
        	Actions acti = new Actions(driver);
        	acti.moveToElement(whowehelping).build().perform();
			
        	Thread.sleep(2000);
	}
	
	//Set<String> windowIds = driver.getWindowHandles();
	
	//Iterator<String> it = windowIds.iterator();
	
	//String pwid = it.next();
	
	//String cwid1 = it.next();
	
	//driver.switchTo().window(cwid1);
	
	driver.findElement(By.id("bfname")).sendKeys("Test");
	
	}
}
