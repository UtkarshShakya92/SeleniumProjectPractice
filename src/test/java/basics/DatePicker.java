package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebElement fr =driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(fr);
		
		///Approach1 : click on date with desired dated .enter date :with format : mm/dd/yyyy
		
		driver.findElement(By.id("datepicker")).sendKeys("07/22/2024");
		
		// Approach 2 ----
		String year ="2026";
		String month ="March";
		String date ="12";
		
		driver.findElement(By.id("datepicker")).click();
		//select month and year
		
		while(true)
		{
			String mth =driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			String yr = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
			
			if(yr.equals(year) && mth.equals(month))
			{
				break;
			}
			
			driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
		
		//Select Date
		
		List<WebElement> allDates =driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement dt:allDates)
		{
			if(dt.getText().equals(date))
			{
				dt.click();
				break;
			}
		}
	}

}
