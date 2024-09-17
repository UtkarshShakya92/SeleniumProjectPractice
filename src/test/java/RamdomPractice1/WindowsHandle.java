package RamdomPractice1;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowsHandle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver() ;
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://www.google.com/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.redbus.in/");
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		driver.get("https://www.orangehrm.com/");
		
		Set<String> allwindows =driver.getWindowHandles();
		
		
		// By using  for loop 
		
		/*for(String wid :allwindows)
		{
			String title = driver.switchTo().window(wid).getTitle();
			
			if(title.equals("Bus Ticket Booking Online made Easy, Secure with Top Bus Operators - redBus"))
			{
				//driver.switchTo().window(wid);
				//driver.findElement(By.id("Form_submitForm_EmailHomePage")).sendKeys("test@gmail.com");
				driver.findElement(By.id("src")).sendKeys("Pune");
				driver.close();
			}
		}*/
		
		//By using iterator 
		
		Iterator<String> it = allwindows.iterator();
		
		String pwid = it.next(); // parent window
		
		String cw1id = it.next(); //1st child window
		
		String cw2id = it.next(); //2nd child window
		
		driver.switchTo().window(cw1id);
		
		driver.findElement(By.id("src")).sendKeys("Pune");
		
		driver.close();
	}

}
