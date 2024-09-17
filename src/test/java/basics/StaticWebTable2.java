package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//no of rows
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("no of rows:"+ rows);
		//no of colums
		
		int colms = driver.findElements(By.xpath("//table[@name='BookTable']//tr//th")).size();
		System.out.println("no of colms:"+ colms);
		
		//print all rows and colms values 
		 
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=colms;c++)
			{
				String values=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(values);
			}
			System.out.println();
		}
		
		
	}

}
