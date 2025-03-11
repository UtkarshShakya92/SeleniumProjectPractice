package RamdomPractice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver =  new ChromeDriver();
		
		driver.get("https://formy-project.herokuapp.com/fileupload");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.findElement(By.xpath("//input[@id='file-upload-field']")).sendKeys("‪C:\\Users\\utk\\Desktop\\Test.txt");
		
		
		//driver.findElement(By.id("file-submit")).click();
		
		
	}

}
