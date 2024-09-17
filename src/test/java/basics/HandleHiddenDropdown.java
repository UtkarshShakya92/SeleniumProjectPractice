package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleHiddenDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		    WebDriver driver = new ChromeDriver();
			
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			
			driver.findElement(By.name("username")).sendKeys("Admin");
			driver.findElement(By.name("password")).sendKeys("admin123");
			
			driver.findElement(By.xpath("//button[.=' Login ']")).click();
			
			//System.out.println(driver.getTitle());
			
			WebDriverWait w =new WebDriverWait(driver,Duration.ofSeconds(5));
			
			w.until(ExpectedConditions.titleContains("OrangeHRM"));
			
			driver.findElement(By.xpath("//span[.='PIM']")).click();
			
			//clicking on job drop down
			driver.findElement(By.xpath("(//label[.='Job Title'] /following:: div/div/div/div[contains(@class,'oxd-select-text--after')]/i)[1]")).click();
			
			//clicking on single job 
			
			//driver.findElement(By.xpath("//span[.='QA Lead']")).click();
			
			//selecting all options
			
			List<WebElement> options =driver.findElements(By.xpath("//div[@role='listbox']//span"));
			
			System.out.println("No of options present are: "+ options.size());
			
			for(WebElement opt:options)
			{
			System.out.println(opt.getText());
			}
	}

}
