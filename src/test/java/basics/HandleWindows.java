package basics;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleWindows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriver driver =new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		//Approach 1
		Set<String> WindowsIds =driver.getWindowHandles();
		
		/*List<String> WindowsIdList = new ArrayList(WindowsIds);//convert set --to list 
		
		String pwid = WindowsIdList.get(0);
		String cwid = WindowsIdList.get(1);
		
		// switch to child window
		
		driver.switchTo().window(cwid);
		
		driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//button[.='Contact Sales']")).click();
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.titleContains("Get in Touch with OrangeHRM Sales | OrangeHRM"));
		
		driver.switchTo().window(pwid);
		*/
		
		//Approch 2 --Enhanced for loop: 
		
		for(String wids:WindowsIds)
		{
			String pageTitle = driver.switchTo().window(wids).getTitle();
			
			if(pageTitle.equals("Human Resources Management Software | OrangeHRM"))
			{
				driver.findElement(By.xpath("//div[@class='d-flex web-menu-btn']//button[.='Contact Sales']")).click();
			}
		}
		
		 
		
	}

}
