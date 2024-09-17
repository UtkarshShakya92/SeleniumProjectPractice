package basics;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlertviaExplicitWait {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10)); //explicit wait declare 
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This none message is before alert");
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();
		
		Alert myalert = mywait.until(ExpectedConditions.alertIsPresent());
		
		System.out.println(myalert.getText());
		
		myalert.accept();
		System.out.println(driver.findElement(By.xpath("//p[@id='result']")).getText()+"This message is after alert");
		
	}

}
