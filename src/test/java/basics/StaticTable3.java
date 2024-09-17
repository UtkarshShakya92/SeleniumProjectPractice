package basics;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.description.annotation.AnnotationValue.Sort;

public class StaticTable3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        WebDriver driver = new ChromeDriver();
		
		driver.get("https://blazedemo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		WebElement dEle= driver.findElement(By.xpath("//Select[@name='fromPort']"));
		
		Select dOptions = new Select(dEle);
		
		dOptions.selectByVisibleText("Boston");
		
		driver.findElement(By.xpath("//Select[@name='toPort']//option[.='Rome']")).click();
		
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		int rows =driver.findElements(By.xpath("//table[@class='table']//tbody//tr")).size();
		System.out.println("No of rows :"+ rows); //5
		
		// capture prices and store it in array
		
		String pricesArr[] = new String[rows];
		
		for(int r=1;r<=rows;r++)
		{
		String prices =driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
		pricesArr[r-1]=prices;
		System.out.println(pricesArr[r-1]);
		}
		
		Arrays.sort(pricesArr);
		String lowestPrice = pricesArr[0];
		System.out.println("Lowest Price:"+pricesArr[0]);
		
		//Find record in table having lower price
		
		for(int r=1;r<=rows;r++)
		{
			String prices =driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[6]")).getText();
			
			if(prices.equals(lowestPrice))
			{
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]//td[1]//input")).click();;
				break;
			}
		}
		
		driver.findElement(By.xpath("//input[@id='inputName']")).sendKeys("Jhon Kenedy");
		driver.findElement(By.id("address")).sendKeys("123 ftfl lsdn rome");
		driver.findElement(By.id("city")).sendKeys("Rome");
		driver.findElement(By.id("zipCode")).sendKeys("12345");
		driver.findElement(By.xpath("//select[@id='cardType']//option[.='American Express']")).click();
		driver.findElement(By.id("creditCardNumber")).sendKeys("1234567890");
		driver.findElement(By.id("nameOnCard")).sendKeys("Jhon");
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		//validation
		
		String msg = driver.findElement(By.xpath("//h1")).getText();
		
		if(msg.contains("Thank you for your purchase today!"))
		{
			System.out.println("Sucess ");
		}
		
		else
		{
			System.out.println("Failed ");
		}
	}
	

}
