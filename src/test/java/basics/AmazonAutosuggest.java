package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AmazonAutosuggest {

 

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait  w = new WebDriverWait(driver,Duration.ofSeconds(15));
		w.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='nav-signin-tooltip']//a//span[.='Sign in']")));
		
	
		
		//WebElement dismiss=driver.findElement(By.xpath("//div[@role='alertdialog'] //div//span//span//span[contains(.,'Dismiss')]"));
		//WebElement dismiss = driver.findElement(By.xpath("//span[@class='a-button-inner'] //span[contains(.,'Dismiss')]"));
		/*JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()",dismiss);*/
		
		//Actions act =  new Actions(driver);
		//act.click(dismiss).build().perform();//
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Smart TV");
		try
		{
		Wait<WebDriver> wait =
		        new FluentWait<>(driver)
		            .withTimeout(Duration.ofSeconds(20))
		            .pollingEvery(Duration.ofSeconds(2))
		            .ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='s-suggestion-container']//div[.='smart tv']")));
		}
		
		catch(StaleElementReferenceException e)
		{
			w.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']"))));
		}
		//ElementNotInteractableException.
		
		//Thread.sleep(4000);
		
		List<WebElement> options =driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']"));
		//w.until(ExpectedConditions.visibilityOfAllElements(options));
		////div[@class='s-suggestion-container']
		//
	     
		System.out.println("no of suggestions : "+options.size());
		
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		driver.quit();
	} 

}
