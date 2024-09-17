package RamdomPractice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost/opencart/upload/admin/index.php?");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("input-username")).sendKeys("admin");
		
		driver.findElement(By.id("input-password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
		
		WebElement crossbutton = driver.findElement(By.xpath("//button[@class='close']"));
		
		if(crossbutton.isDisplayed())
		{
			crossbutton.click();
		}
		
		driver.findElement(By.xpath("//li[@id='menu-customer']/a")).click();
		
		driver.findElement(By.xpath("//li[@id='menu-customer']//ul//li//a[.='Customers']")).click();
		
		String text = driver.findElement(By.xpath("//div[contains(text(),'Showing')]")).getText();
		
		int total_pages = Integer.parseInt(text.substring(text.indexOf("(")+1,text.indexOf("Pages")-1));
		
		for(int p=1;p<=total_pages;p++)
		{
			if(p>1)
			{
				WebElement active_page =driver.findElement(By.xpath("//ul[@class='pagination']//li//a[.='"+p+"']"));
				active_page.click();
				Thread.sleep(3000);
			}
			
			//count noOfrows
			
			int noOfRows = driver.findElements(By.xpath("//form[@id='form-customer']//tbody//tr")).size();
			
			for(int r=1;r<=noOfRows;r++)
			{
			String userName =driver.findElement(By.xpath("//form[@id='form-customer']//tr["+r+"]/td[2]")).getText();
			String email =driver.findElement(By.xpath("//form[@id='form-customer']//tr["+r+"]/td[3]")).getText();
			String status =driver.findElement(By.xpath("//form[@id='form-customer']//tr["+r+"]/td[5]")).getText();
			System.out.println(userName+"\t"+email+"\t"+status);
		     }
		}
	}

}
