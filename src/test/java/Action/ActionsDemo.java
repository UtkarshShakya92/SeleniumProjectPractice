package Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		Thread.sleep(20000);
		WebElement notic = driver.findElement(By.xpath("//img[@alt='Close Feedback']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(notic.isDisplayed())
		{
			
			js.executeScript("arguments[0].click();",notic );
		}
		
		//driver.findElement(By.xpath("//button[@title='Next Slide']//span[@class=\"_2o9o_t\"]"));
		
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[@title='Next Slide']//span[@class=\"_2o9o_t\"]")));
		WebElement elec= driver.findElement(By.xpath("//img[@class='_2puWtW _3a3qyb' and @alt='Electronics']"));
		
		//WebElement gam = driver.findElement(By.xpath("//a[@class='_1BJVlg _11MZbx']"));
		
		
		//WebElement gc = driver.findElement(By.xpath("//a[@class='_3490ry' and .='Gaming Consoles']"));
		
		Actions act = new Actions(driver);
		
		//Mousehover
		
		act.moveToElement(elec).build().perform();
		Thread.sleep(1000);
		WebElement gam = driver.findElement(By.xpath("//a[.='Gaming']"));
		act.moveToElement(gam).click().build().perform();
	}

}
