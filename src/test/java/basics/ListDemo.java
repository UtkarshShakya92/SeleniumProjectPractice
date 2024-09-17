package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ListDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		
		driver.manage().window().maximize();
		
		List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
		
		int countlist = allLinks.size();
		
		System.out.println(countlist);
		
		for(int i=0; i<countlist; i++ )
		{
			WebElement link = allLinks.get(i);
			
			String text = link.getText();
			
			System.out.println(text);
			
		}
		
		allLinks.get(countlist -1).click();
		}

}
