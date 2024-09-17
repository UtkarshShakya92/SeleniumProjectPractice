package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PaginationTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

        WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.opencart.com/admin/index.php");
		driver.manage().window().maximize();
		
		WebElement username = driver.findElement(By.id("input-username"));
		
		username.clear();
		username.sendKeys("demo");
		
		WebElement pass = driver.findElement(By.id("input-password"));
		pass.clear();
		pass.sendKeys("demo");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		if(driver.findElement(By.xpath("//button[@class='btn-close']")).isDisplayed())
		{
			driver.findElement(By.xpath("//button[@class='btn-close']")).click();
		}
		
		
		///cutomer parent customer click
		
		driver.findElement(By.xpath("//a[@class='parent collapsed' and .=' Customers']")).click();
		
		/// inside customer again customer click
		
        driver.findElement(By.xpath("//ul[@id=\"collapse-5\"]//a[.='Customers']")).click();
        
        //showing the total number of pages in a string --- Showing 1 to 10 of 20374 (2038 Pages)
        String text = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
        
        //retreiving  total pages inside the braces
        
        int total_pages =Integer.parseInt(text.substring(text.indexOf("(")+1, text.indexOf("Pages")-1));
        
        System.out.println("Total number of pages:"+total_pages);
        
        for(int p=1;p<=total_pages;p++)
        {
        	if(p>1)
        	{
        		//WebElement active_Page= driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()='"+p+"']"));
        		
        		WebElement active_Page=driver.findElement(By.xpath("//ul[@class='pagination']//li//*[text()="+p+"]"));
        		
        		///[.="+p+"]"  ---it is used to retrieve the page number dynamically 
        		
        		System.out.println(" Active Page : "+active_Page.getText());
        		
        		JavascriptExecutor jse = (JavascriptExecutor) driver;
        		jse.executeScript("arguments[0].click();",active_Page);
        		//active_Page.click();
				Thread.sleep(2000);
        	}
        	
        	int noOfrows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
        	System.out.println(" Total No Of Rows in active Page : "+noOfrows);
        	
        	for(int r=1;r<=noOfrows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[2]")).getText();
				String customerEmail=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]//td[5]")).getText();
				
				System.out.println(customerName+"      "+customerEmail+"          "+status);
			}
        }
        driver.quit();
	}

}
