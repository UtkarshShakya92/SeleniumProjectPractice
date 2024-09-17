package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CssSelectorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		//tag id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("HP");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("HP");
		
		//tag and class
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Laptop");
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Laptop");
		
		//tag and attribute
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Laptop");
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Laptop");
		
		//tag class and attribute.
		
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Laptops");
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Laptops");
	}
	

}
