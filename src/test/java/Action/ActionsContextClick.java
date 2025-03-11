package Action;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ActionsContextClick {

	@Test
	public void actContextClick() throws AWTException, InterruptedException
	{
		WebDriver driver  = new ChromeDriver();
		
		driver.get("https://orangehrm.com/");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement ele = driver.findElement(By.xpath("//a[text()='Pricing']"));
		
		Actions act = new Actions(driver);
		
		//act.sendKeys(Keys.CONTROL).click(ele).build().perform();
		
		act.keyDown(Keys.CONTROL).click(ele).keyUp(Keys.CONTROL).build().perform();
		
		/*//act.contextClick(ele).build().perform();
		//act..build().perform();
		
		//act.sendKeys(Keys.CONTROL).click(ele).build().perform();
		
		Thread.sleep(2000);
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_T);
		r.keyRelease(KeyEvent.VK_T);*/
	}
}
