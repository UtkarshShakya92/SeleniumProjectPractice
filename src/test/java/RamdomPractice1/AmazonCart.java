package RamdomPractice1;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AmazonCart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//ChromeOptions options = new ChromeOptions();
		//options.addArguments("--disable-notifications");

		WebDriver driver = new FirefoxDriver();
		
		driver.get("https://www.amazon.in");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("iphone");
		
		WebDriverWait mywait  = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']//div[.='iphone']")));
		
		List<WebElement> items = driver.findElements(By.xpath("//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']"));
		
		System.out.println("No of options present for iphone :"+ items.size());
		
		for(int i=0; i<items.size();i++)
		{
			if(items.get(i).getText().equalsIgnoreCase("iphone 15 pro"))
			{
				items.get(i).click();
				break;
			}
		}
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Amazon.in : iphone 15 pro");
		System.out.println("In the iphone 15 page");
		
		//waiting conditions wrt elemenets to visible 
		
		 mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[.='Apple iPhone 15 Pro (128 GB) - White Titanium']")));
		 
		 //clicking on element 
		 WebElement Reqiphone =driver.findElement(By.xpath("//span[.='Apple iPhone 15 Pro (128 GB) - White Titanium']"));
		 
		 if(Reqiphone.getText().equalsIgnoreCase("Apple iPhone 15 Pro (128 GB) - White Titanium"))
		 {
			 Reqiphone.click();
			 System.out.println("Apple iPhone 15 Pro (128 GB) - White Titanium : selected");
		 }
		
		 Set<String> allwids =driver.getWindowHandles();
		 
		 for(String wids : allwids)
		 {
			 driver.switchTo().window(wids);
		 }
		
		 mywait.until(ExpectedConditions.presenceOfElementLocated(By.id("add-to-cart-button")));
		
		 driver.findElement(By.id("add-to-cart-button")).click();
		 
		 try {
		 WebElement cartmsg = mywait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@id='attach-close_sideSheet-link']")));
		 if(cartmsg.isDisplayed())
		 {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()",cartmsg);
		 }
		 }
		 
		 catch(Exception e)
		 {
			 System.out.println("cross not interacted");
		 }
		 
		// Open the cart
		 driver.findElement(By.id("nav-cart-count-container")).click();
		 
		 //waiting for cart page to load
		 WebElement cartItem = mywait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".a-truncate-cut")));
		 
		 System.out.println(cartItem.getText());
		 if(cartItem.getText().toLowerCase().contains("iphone"))
		 {
			 System.out.println("Product successfully added to the cart and validated.");
		 }
		 
		 else
		 {
			 System.out.println("Product is not present .");
		 }
		 
		 driver.quit();
	}

}
