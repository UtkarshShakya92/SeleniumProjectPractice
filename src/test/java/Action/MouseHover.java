package Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseHover {
	
	@Test(groups={"mouseHover"})
	public void movToElement()
	{
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://orangehrm.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Actions act = new Actions(driver); 
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Resources']"));
		
		act.moveToElement(ele).build().perform();
		
		WebElement ele2 = driver.findElement(By.xpath("(//a[text()='Learn in Depth'])[1]"));
		
		act.moveToElement(ele2).build().perform();
		
		WebElement ele3 = driver.findElement(By.partialLinkText("HR's Guide"));
		
		act.moveToElement(ele3).click().build().perform();
		
		driver.close();
		
	}

}
