package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Checkbox {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		/*WebElement ele =driver.findElement(By.xpath("//label[.='Days:']"));
		Actions act = new Actions(driver);
		act.moveToElement(ele).perform();*/
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,680)"," ");
		
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		List<WebElement> checkboxes =driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		/*for(int i=0; i<checkboxes.size() ;i++)
		{
			checkboxes.get(i).click();
		}*/
		
		/*for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}*/
		// Should have to select only last 3 out of total 7 days
		//7-3=4 so the index will start from 4(total number of checkboxes -ow many checkboxes need to select = starting index)
		
		
		/*for(int i=4 ; i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//selecct 1st 3 checkboxes (index will start from 0) so 0,1,2 position
		/*for(int i=0;i<3 ; i++)
		{
			checkboxes.get(i).click();
		}*/
		
		//first select the checkboxes after some time deselect them.
		
		for(int i=0;i<3 ; i++)
		{
			checkboxes.get(i).click();
		}
		
		Thread.sleep(2000);
		
		for(int i=0; i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();
			}
		}
		
		//http://www.automationpractice.pl/index.php
		//https://www.techlistic.com/p/selenium-practice-form.html
		//https://training.rcvacademy.com/test-automation-practice-page
	}

}
