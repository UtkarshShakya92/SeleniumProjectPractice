package Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ActionDragAndDrop {

	@Test
	public void dragAndDrop()
	{
		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://www.globalsqa.com/demo-site/draganddrop/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele = driver.findElement(By.xpath("//iframe[@class='demo-frame lazyloaded']"));
		
		driver.switchTo().frame(ele);
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h5[text()='High Tatras 2']")));
		
		WebElement source =driver.findElement(By.xpath("//h5[text()='High Tatras 2']"));
		
		WebElement target = driver.findElement(By.id("trash"));
		
		Actions act = new Actions(driver);
		
		act.dragAndDrop(source, target).build().perform();
	}
}
