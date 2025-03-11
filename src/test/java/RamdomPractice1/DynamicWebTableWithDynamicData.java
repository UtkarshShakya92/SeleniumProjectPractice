package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class DynamicWebTableWithDynamicData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://practice.expandtesting.com/dynamic-table");

		driver.manage().window().maximize();

		List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

		System.out.println(rows.size());

		for (int r = 1; r <= rows.size(); r++)

		{
			String name = driver.findElement(By.xpath("//table//tbody//tr[" + r + "]//td[1]")).getText();
			
			if (name.equalsIgnoreCase("Chrome")) {
				String rowcpuvalue = driver
						.findElement(By.xpath(
								"//table//tbody//tr//td[text()='Chrome']//following-sibling::*[contains(text(),'%')]"))
						.getText();
				
				String colcpuvalue = driver.findElement(By.id("chrome-cpu")).getText();
				
				if (colcpuvalue.contains(rowcpuvalue)) {
					System.out.println("The Chrome Cpue value is matched");

					Assert.assertTrue(true);
				}

				else {
					System.out.println("The Chrome Cpu value is not  matched");

					Assert.assertTrue(false); 
				} 
				break;
			}
               
		}

	}

}
