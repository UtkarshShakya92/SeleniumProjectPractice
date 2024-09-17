package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdminArea {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
		
		WebElement emailtext = driver.findElement(By.className("email"));
		
		emailtext.clear();
		
		WebElement pass =driver.findElement(By.id("Password"));
		pass.clear();
		
		emailtext.sendKeys("admin@yourstore.com");
		pass.sendKeys("admi");
		
		//Dashboard / nopCommerce administration
		
		driver.findElement(By.className("button-1")).click();
		
		String act_title=driver.getTitle();
		String exp_title="Dashboard / nopCommerce administration";
		
		if (act_title.equals(exp_title))
		{
			System.out.println("Test is passed : Title is correct");
		}
		
		else
		{
			System.out.println("Test is failed : Title is inncorrect");
		}
        
		String act_label = " ";
		try
		{
		act_label = driver.findElement(By.xpath("//div[@class='content-header']/h1")).getText();
		}
		
		catch(NoSuchElementException e) {}
		
		
		String exp_label = "Dashboard";
		
		if (act_label.equals(exp_label))
		{
			System.out.println("Test is passed : label is correct");
		}
		
		else
		{
			System.out.println("Test is failed : label is inncorrect");
		}
		
		driver.quit();	
		
		///https://magento.softwaretestingboard.com/
		//http://www.automationpractice.pl/index.php

}
}
