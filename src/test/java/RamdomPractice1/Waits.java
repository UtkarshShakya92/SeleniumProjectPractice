package RamdomPractice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.aspnetawesome.com/");
		
		//WebElement errorbutton = driver.findElement(By.xpath("//button[text()='Show Erro']"));
		//button[text()='Show Erro']
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(5));
		mywait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[text()='Show Erro']")));
	}

}
