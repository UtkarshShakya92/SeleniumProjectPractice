package RamdomPractice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import basics.ScrollBy;

public class SelectDrpDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =  new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,100)"," ");
		
		WebElement drpdown = driver.findElement(By.id("country"));
		
		Select sel = new Select(drpdown);
		
		sel.selectByValue("germany");
	}

}
