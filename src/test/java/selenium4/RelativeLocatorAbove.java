package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.openqa.selenium.support.locators.RelativeLocator.*;

public class RelativeLocatorAbove {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//above
		
		WebElement nameField = driver.findElement(By.xpath("//input[@name='name']"));
		
		String labelName = driver.findElement(with(By.tagName("label")).above(nameField)).getText();
		
		System.out.println(labelName);
		
		//below
		
		WebElement datefieldtext = driver.findElement(By.xpath("//label[text()='Date of Birth']"));
		
		driver.findElement(with(By.tagName("input")).below(datefieldtext)).click();
		
		//toLeftOf
		
		WebElement checkboxtext = driver.findElement(By.xpath("//label[text()='Check me out if you Love IceCreams!']"));
		
		driver.findElement(with(By.tagName("input")).toLeftOf(checkboxtext)).click();
		
		WebElement rdb = driver.findElement(By.id("inlineRadio1"));
		
		System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(rdb)).getText());
	}

}
