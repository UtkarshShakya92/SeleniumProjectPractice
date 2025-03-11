package RamdomPractice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     WebDriver driver =  new ChromeDriver();
     
     driver.manage().window().maximize();
     
     driver.get("https://www.ecomdeveloper.com/demo/admin/index.php");
     
     driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
     
     driver.findElement(By.id("input-username")).sendKeys("demoadmin");
     
     driver.findElement(By.id("input-password")).sendKeys("demopass");
     
     driver.findElement(By.xpath("//button[@type='submit']")).click();
     
     JavascriptExecutor js = (JavascriptExecutor)driver;
     
     js.executeScript("window.scrollBy(0,30)");
     
     driver.findElement(By.id("menu-customer")).click();
     
     driver.findElement(By.xpath("//ul[@id='collapse9']//li//a[contains(@href,'route=customer')]")).click();
     
     js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
     
     String pagestext = driver.findElement(By.xpath("//div[contains(text(),'Pages')]")).getText();
     
     System.out.println(pagestext);
     
     int startingindex= pagestext.indexOf("(")+1;
     int endingindex = pagestext.indexOf("Pages")-1;
     int noOfPages = Integer.parseInt(pagestext.substring(startingindex,endingindex));
     System.out.println(noOfPages);
	}

}
