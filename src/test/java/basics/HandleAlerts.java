package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This none message is before alert");
		
		Thread.sleep(5000);
		
		/*driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
		
		Alert myalert =driver.switchTo().alert();
		
		System.out.println(myalert.getText());
		myalert.accept();
		
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This message is after alert");
		*/
		
        /*driver.findElement(By.xpath("//button[.='Click for JS Confirm']")).click();
		
		Alert myalert =driver.switchTo().alert();
		
		System.out.println(myalert.getText());
		
		myalert.dismiss();
		
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This message is after alert");
		*/
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
		
		Alert myalert =driver.switchTo().alert();
		
		System.out.println(myalert.getText());
		
		myalert.sendKeys("welcome");
		
		myalert.accept();
		
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This message is after alert");
	}

}
