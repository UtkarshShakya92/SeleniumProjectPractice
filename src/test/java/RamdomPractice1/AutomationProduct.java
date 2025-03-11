package RamdomPractice1;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class AutomationProduct {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().deleteAllCookies();
		
		driver.get("https://automationexercise.com/products");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		Actions act = new Actions(driver);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");

		Thread.sleep(2000);

		WebElement bluetop_ele = driver
				.findElement(By.xpath("//div[@class='productinfo text-center']//p[text()='Blue Top']"));
		act.moveToElement(bluetop_ele).build().perform();

		WebElement firstProduct = driver.findElement(By.xpath("(//a[@data-product-id='1'])[2]"));

		js.executeScript("arguments[0].click()", firstProduct);

		// WebElement continue_section =
		// driver.findElement(By.cssSelector(".modal-content"));

		// act.moveToElement(continue_section).build().perform();

		WebElement continue_btn = driver.findElement(By.cssSelector(".modal-footer .btn"));

		continue_btn.click();
		// js.executeScript("arguments[0].click()",continue_btn);

		Thread.sleep(1000);

		WebElement secondProduct_ele = driver
				.findElement(By.xpath("//div[@class='productinfo text-center']//p[text()='Men Tshirt']"));
		act.moveToElement(secondProduct_ele).build().perform();

		WebElement SecondProduct = driver.findElement(By.xpath("(//a[@data-product-id='2'])[2]"));

		js.executeScript("arguments[0].click()", SecondProduct);

		// view Cart

		driver.findElement(By.xpath("//div[@class='modal-body']//p//a[@href='/view_cart']")).click();

		//verifying product from table
		
		List<WebElement> firstProductsDetails  =driver.findElements(By.id("product-1"));
		List<WebElement> secondProductsDetails  =driver.findElements(By.id("product-2"));
		
		HashMap<Integer,String> map = new HashMap<Integer,String>();
		map.put(1, "Blue Top");
		map.put(1, "Women > Tops");
		map.put(1,"Rs. 500");
		map.put(1, "1");
		map.put(1,"Rs. 500");
		map.put(2, "Men Tshirt");
		map.put(2, "Men > Tshirts");
		map.put(2, "Rs. 400");
		map.put(2, "1");
		map.put(2, "Rs. 400");
		
		for(int i=0;i<firstProductsDetails.size();i++)
		{
			Assert.assertTrue(firstProductsDetails.get(i).getText().contains(map.get(1)));
			Assert.assertTrue(secondProductsDetails.get(i).getText().contains(map.get(2)));
		}

		System.out.println("Products and prices are verified");
	}
}

/*// WebTable

		WebElement webTable = driver.findElement(By.xpath("//table[@id='cart_info_table']"));

		// get all rows

		int rows = driver.findElements(By.xpath("//table[@id='cart_info_table']//tbody//tr")).size();

		System.out.println("no of rows :" + rows);

		// colms

		int cols = driver.findElements(By.xpath("//table[@id='cart_info_table']//tr[@class='cart_menu']//td")).size();

		System.out.println("no of cols :" + cols);

		// print all rows and colums
		String[] itemsinCart = { "Blue Top", "Men Tshirt" };

		List<String> items = Arrays.asList(itemsinCart);
		for (int r = 1; r <= rows; r++) {

			for (int c = 1; c <= cols - 5; c++) {
				String rowcolvalue = driver
						.findElement(By.xpath("//table[@id='cart_info_table']//tbody//tr[" + r + "]//td[2]//a"))
						.getText();

				System.out.print(rowcolvalue);

				// String[] itemName = rowcolvalue.getText().split("-");
				// String formattedItemName =itemName[0].trim();

				if (items.contains(rowcolvalue)) {
					System.out.println("  :The product is verified");
				}	
			}
		}
		
		// verify price , quantitiy , total price

		for (int i = 1; i <= rows; i++) 
		{
			
		for (int j = 3; j <= cols - 1; j++)
		{
			String rowcol= driver.findElement(By.xpath("//table[@id='cart_info_table']//tbody//tr[" + i + "]//td["+j+"]")).getText();

			System.out.println(rowcol);

			// String[] itemName = rowcolvalue.getText().split("-");
			// String formattedItemName =itemName[0].trim();

		}

		}
		*/
