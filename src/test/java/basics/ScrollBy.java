package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ScrollBy {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		
		
		WebElement element = driver.findElement(By.xpath("//button[text()='New Browser Window']"));
		//jse.executeScript("window.scrollBy(0,1000)");
		
		//jse.executeScript("arguments[0].click()", element);
		Actions act = new Actions(driver);
		
		act.keyDown(Keys.SHIFT).click(element).build().perform();
		
		//jse.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		//jse.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		//System.out.println(jse.executeScript("return window.pageYOffset;"));
	}

}
