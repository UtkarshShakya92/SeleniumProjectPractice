package basics;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenShots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		/*TakesScreenshot ts = (TakesScreenshot) driver; 
		
		File sourcefile = ts.getScreenshotAs(OutputType.FILE);
		
		File targetfile = new File(System.getProperty("user.dir")+"//screenshots//fullpage.png");
		
		sourcefile.renameTo(targetfile);
		*/
		
		//Capture the sceeen shot of specific section
		WebElement featuredproduct =driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
		
        File sourcefile = featuredproduct.getScreenshotAs(OutputType.FILE);
		
		File targetfile = new File(System.getProperty("user.dir")+"//screenshots//featuredproduct.png");
		
		sourcefile.renameTo(targetfile);
		
	}

}
