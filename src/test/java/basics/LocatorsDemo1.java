package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsDemo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		
		driver.findElement(By.id("search_query_top")).sendKeys("T-shirts");
		
		driver.findElement(By.name("submit_search")).click();
		
		//driver.findElement(By.linkText("Printed Chiffon Dress")).click();
		
		driver.findElement(By.partialLinkText("Chiffon Dress")).click();
	}

}
