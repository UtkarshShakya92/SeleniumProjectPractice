package RamdomPractice1;

import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WebShop {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
         
		WebDriver driver = new ChromeDriver();

		//WebDriver driver = new FirefoxDriver();
		
		driver.manage().deleteAllCookies();
		
		driver.get("https://demowebshop.tricentis.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//2.select "books" under categories
		//3. change "Display Per Page" to 12

		driver.findElement(By.xpath("//div[@class='listbox']//li//a[normalize-space()='Books']")).click();

		WebElement disize = driver.findElement(By.id("products-pagesize"));

		Select se = new Select(disize);

		se.selectByVisibleText("12");
		

	  // mywait.until(ExpectedConditions.refreshed())
		Thread.sleep(2000);

		WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		//4. add to cart all products that have an add to cart button
		
		

		
		List<WebElement> products = driver.findElements(By.xpath("//div[@class='item-box']"));

		int acb = products.size();

		for (int i = 0; i < acb; i++) {
			// System.out.println(products.get(i).getText());
			String value = products.get(i).getAttribute("class");

			if (value.contains("item-box")) {
				try {
					// click on add t cart
					driver.findElements(By.xpath("//div[@class='buttons']//input[@value='Add to cart']")).get(i)
							.click();
				}

				catch (Exception IndexOutOfBoundsException) {

				}
			}
			// WebElement options = elements.get(i);
			// options.click();    .loading-image 
			mywait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".content")));
			
			mywait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".loading-image")));
		}

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,67)","");
		
		// mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-productid='22']")));

		// 5.click on the "shopping cart" link
		// 6. verify that there are 3 products in the cart

		WebElement shoppingCart = driver.findElement(By.xpath("//span[text()='Shopping cart']"));

		Actions act = new Actions(driver);
		act.moveToElement(shoppingCart).build().perform();

		String cartNoOfitems = driver.findElement(By.xpath("//a[@class='items']")).getText();

		if (cartNoOfitems.contains("3")) {
			Assert.assertTrue(true);

			System.out.println("The Cart Contains 3 items");
		}
		
		else
		{
			Assert.fail();
		}

		// 7. verify that the correct products are in the cart
		//// table[@class='cart']//tr//td[3]//a

		shoppingCart.click();

		String[] reqProds = { "Computing and Internet", "Fiction", "Health Book" };

		List<WebElement> reqProdsList = driver.findElements(By.xpath("//table[@class='cart']//tr//td[3]//a"));

		List verifyReqProdList = Arrays.asList(reqProds);
		int j=0;
		for (int i = 0; i < reqProdsList.size(); i++) 
		{
			String verifyReqProd = reqProdsList.get(i).getText();

			

			// Assert.assertEquals(verifyReqProdList,verifyReqProd);

			//System.out.println("Array list prepaired");
			 if(verifyReqProdList.contains(verifyReqProd)) 
			 {
			    j++;
				 
			    
			    if(j==reqProds.length)
			    {
			    	
			    	break;
			    }
			  }
			 
		}
		
		System.out.println("Products in cart are verified");

		
		/*
		 * 8. select all fields for shipping
           9. check the "terms of service" checkbox
           10. click the "checkout" button
           11. checkout as guest
		 */
		//JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,870)","");
		
		driver.findElement(By.xpath("//div[@class='shipping-options']//Select//option[text()='United States']")).click();
		
		driver.findElement(By.xpath("//div[@class='shipping-options']//Select//option[text()='Arizona']")).click();
		
		driver.findElement(By.id("ZipPostalCode")).sendKeys("23456");
		
		driver.findElement(By.name("estimateshipping")).click();
	
		driver.findElement(By.id("termsofservice")).click();
		
		driver.findElement(By.id("checkout")).click();
		
		//on Demo login page 
		String loginTitle = driver.getTitle();
		
		Assert.assertEquals("Demo Web Shop. Login", loginTitle);
		
		driver.findElement(By.xpath("//div[@class='buttons']//input[@value='Checkout as Guest']")).click();
		
		//checking we are in Check out //billing address page 
		//
		Assert.assertEquals("Demo Web Shop. Checkout", driver.getTitle());
		
		//Fill in/select billing address
		
		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Test");
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Testing");
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("test@gmail.com");
		
		Select selectBillCounty = new Select (driver.findElement(By.id("BillingNewAddress_CountryId")));
		
		selectBillCounty.selectByVisibleText("India");
		
		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("TestCity");
		
		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("10 test 2346");
		
		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("23456");
		
		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9999999999");
		
		driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input[@value='Continue']")).click();
		
		//fill in/select shipping address
		
		//driver.findElement(By.id("PickUpInStore")).click();
		
		Select shippingaddlist = new Select(driver.findElement(By.id("shipping-address-select")));
		shippingaddlist.selectByVisibleText("New Address");
		//Entering shipping address 
		driver.findElement(By.id("ShippingNewAddress_FirstName")).sendKeys("TestShipping");
		driver.findElement(By.id("ShippingNewAddress_LastName")).sendKeys("Testing");
		driver.findElement(By.id("ShippingNewAddress_Email")).sendKeys("test@gmail.com");
		
	
		Select selectShipCounty = new Select (driver.findElement(By.id("ShippingNewAddress_CountryId")));
		
		selectShipCounty.selectByVisibleText("Switzerland");
		
		driver.findElement(By.id("ShippingNewAddress_City")).sendKeys("TestCity");
		
		driver.findElement(By.id("ShippingNewAddress_Address1")).sendKeys("10 test 2346");
		
		driver.findElement(By.id("ShippingNewAddress_ZipPostalCode")).sendKeys("23456");
		
		driver.findElement(By.id("ShippingNewAddress_PhoneNumber")).sendKeys("9999999999");
		
		driver.findElement(By.xpath("//div[@id='shipping-buttons-container']//input[@value='Continue']")).click();
		
		//Shipping Method
		driver.findElement(By.id("shippingoption_1")).click();
		
		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//input[@type='button']")).click();
		
		
		//payment method
		//15. fill in/select payment method
		//16. fill in/select payment information
		//17. confirm order
		
		driver.findElement(By.id("paymentmethod_1")).click();	
		
		driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input[@value='Continue']")).click();
		
		driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input[@value='Confirm']")).click();
		
		//Your order has been successfully processed!
		
		String ordersucess = driver.findElement(By.xpath("//div[@class='title']/strong")).getText();
		
		
		Assert.assertEquals(ordersucess, "Your order has been successfully processed!");
		
		System.out.println("The order is successfull");
		
		driver.findElement(By.linkText("Click here for order details.")).click();
		
		//Thread.sleep(2000);
		
		WebElement table= driver.findElement(By.xpath("//table[@class='data-table']"));
		
		//get all rows 
		
		
		int rows = driver.findElements(By.xpath("//table[@class='data-table']//tbody//tr")).size();
		System.out.println("No of rows :"+ rows);
		//get all colms
		
		int cols = driver.findElements(By.xpath("//table[@class='data-table']//th")).size();

		for(int r=1;r<=rows;r++)
		{
			
			for(int c=1;c<=cols;c++)
			{
				
				String rowcolvalue = driver.findElement(By.xpath("//table[@class='data-table']//tr["+r+"]//td["+c+"]")).getText();
				
				System.out.print(rowcolvalue +"     ");
				
				
			}
			
			System.out.println();
			if(r==rows)
			{
				break;
			}
		
			
		}	
		}

}
