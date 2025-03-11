package RamdomPractice1;

import java.awt.AWTException;
import java.awt.Robot;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMNewTabs {

	public static void main(String[] args) throws InterruptedException, AWTException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.orangehrm.com/");
		
		driver.manage().window().maximize();
		
		WebElement button = driver.findElement(By.xpath("(//a//button[text()='Book a Free Demo'])"));
		
		button.click();
		
		//act.sendKeys("t");
		
		//Robot r = new Robot();
		
		//r.keyPress
		
		/*
		WebDriverWait myWait = new WebDriverWait(driver,Duration.ofSeconds(20));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		Thread.sleep(2000);
		
		List<WebElement> learnMorelinks = driver.findElements(By.xpath("//h5[text()='About Us']//following-sibling:: ul//li//a"));
		System.out.println(learnMorelinks.size());
		Actions act = new Actions(driver);
		for(int i=0;i<learnMorelinks.size();i++)
		{
			//myWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//li//a[contains(@href,'orangehrm-privacy-policy')]")));
			System.out.println(learnMorelinks.get(i));
			//learnMorelinks.get(i).click();
			
			act.keyDown(Keys.CONTROL).click(learnMorelinks.get(i)).keyUp(Keys.CONTROL).build().perform();
			
			///act.sendKeys(Keys.CONTROL).click(learnMorelinks.get(i)).sendKeys(Keys.UP).build().perform();		
		}
			*/	

	}

}
