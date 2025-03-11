package selenium4;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class NewTab {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles  =driver.getWindowHandles();
		
		Iterator<String> it = handles.iterator();
		String pwid = it.next();
		String chwid1 = it.next();
		
		driver.switchTo().window(chwid1);
		
		driver.get("https://rahulshettyacademy.com/");
		
		//String firstcourse = driver.findElements(By.xpath("//h2//a[contains(@href,'https://courses.rahulshettyacademy.com/p')]")).get(0).getText();
		
		String firstcourse = driver.findElements(By.cssSelector("h2 a[href*='https://courses.rahulshettyacademy.com/p']")).get(0).getText();
		
		driver.switchTo().window(pwid);
		
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(firstcourse);
		
		driver.quit();
		
	}

}
