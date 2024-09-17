package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalCommands {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.nopcommerce.com/en/register?returnUrl=%2Fen");
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
		driver.manage().window().maximize();
		
		WebElement logo = driver.findElement(By.xpath("//img[@title='nopCommerce']"));
		System.out.println(logo.isDisplayed());
		
		
	}

}
