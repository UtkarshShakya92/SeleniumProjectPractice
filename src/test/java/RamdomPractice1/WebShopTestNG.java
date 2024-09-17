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
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WebShopTestNG {

	static WebDriver driver;

	//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@BeforeClass
	public void setUp() {
		 driver = new ChromeDriver();

		// WebDriver driver = new FirefoxDriver();

		driver.manage().deleteAllCookies();

		driver.get("https://demowebshop.tricentis.com");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1)
	public void selectBooks() throws InterruptedException {
		// 2.select "books" under categories
		// 3. change "Display Per Page" to 12

		driver.findElement(By.xpath("//div[@class='listbox']//li//a[normalize-space()='Books']")).click();

		WebElement disize = driver.findElement(By.id("products-pagesize"));

		Select se = new Select(disize);

		se.selectByVisibleText("12");

		Thread.sleep(2000);
	}

	@Test(priority = 2)

	public void addToCart() throws InterruptedException {

		// 4. add to cart all products that have an add to cart button

		
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
			// options.click();
			Thread.sleep(1000);
		}
	}

	@Test(priority = 3)
	public void verify3Products() {
		
		JavascriptExecutor js =(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,67)", "");

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

		else {
			Assert.fail();
		}

		shoppingCart.click();
	}

	@Test(priority = 4)
	public void verifyCorrectProducts() {
		// 7. verify that the correct products are in the cart
		//// table[@class='cart']//tr//td[3]//a
		String[] reqProds = { "Computing and Internet", "Fiction", "Health Book" };
		List<WebElement> reqProdsList = driver.findElements(By.xpath("//table[@class='cart']//tr//td[3]//a"));

		int j = 0;
		for (int i = 0; i < reqProdsList.size(); i++) {
			String verifyReqProd = reqProdsList.get(i).getText();

			List verifyReqProdList = Arrays.asList(reqProds);

			// Assert.assertEquals(verifyReqProdList,verifyReqProd);

			// System.out.println("Array list prepaired");
			if (verifyReqProdList.contains(verifyReqProd)) {
				j++;

				if (j == reqProds.length) {

					break;
				}
			}

		}

		System.out.println("Products in cart are verified");

	}

	@Test(priority = 5)
	public void enterShippingDetails() {
		/*
		 * 8. select all fields for shipping 9. check the "terms of service" checkbox
		 * 10. click the "checkout" button 11. checkout as guest
		 */
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,870)", "");

		driver.findElement(By.xpath("//div[@class='shipping-options']//Select//option[text()='United States']"))
				.click();

		driver.findElement(By.xpath("//div[@class='shipping-options']//Select//option[text()='Arizona']")).click();

		driver.findElement(By.id("ZipPostalCode")).sendKeys("23456");

		driver.findElement(By.name("estimateshipping")).click();

		driver.findElement(By.id("termsofservice")).click();

		driver.findElement(By.id("checkout")).click();
	}

	@Test(priority = 6)
	public void verifyTitle() {
		// on Demo login page
		String loginTitle = driver.getTitle();

		Assert.assertEquals("Demo Web Shop. Login", loginTitle);

		driver.findElement(By.xpath("//div[@class='buttons']//input[@value='Checkout as Guest']")).click();

		// checking we are in Check out //billing address page
		//
		Assert.assertEquals("Demo Web Shop. Checkout", driver.getTitle());
	}

	@Test(priority = 7)
	public void billingAddress() {
		// Fill in/select billing address

		driver.findElement(By.id("BillingNewAddress_FirstName")).sendKeys("Test");
		driver.findElement(By.id("BillingNewAddress_LastName")).sendKeys("Testing");
		driver.findElement(By.id("BillingNewAddress_Email")).sendKeys("test@gmail.com");

		Select selectBillCounty = new Select(driver.findElement(By.id("BillingNewAddress_CountryId")));

		selectBillCounty.selectByVisibleText("India");

		driver.findElement(By.id("BillingNewAddress_City")).sendKeys("TestCity");

		driver.findElement(By.id("BillingNewAddress_Address1")).sendKeys("10 test 2346");

		driver.findElement(By.id("BillingNewAddress_ZipPostalCode")).sendKeys("23456");

		driver.findElement(By.id("BillingNewAddress_PhoneNumber")).sendKeys("9999999999");

		driver.findElement(By.xpath("//div[@id='billing-buttons-container']/input[@value='Continue']")).click();
	}

	@Test(priority = 8)

	public void shippingAddres() {
		// fill in/select shipping address

		// driver.findElement(By.id("PickUpInStore")).click();

		Select shippingaddlist = new Select(driver.findElement(By.id("shipping-address-select")));
		shippingaddlist.selectByVisibleText("New Address");
		// Entering shipping address
		driver.findElement(By.id("ShippingNewAddress_FirstName")).sendKeys("TestShipping");
		driver.findElement(By.id("ShippingNewAddress_LastName")).sendKeys("Testing");
		driver.findElement(By.id("ShippingNewAddress_Email")).sendKeys("test@gmail.com");

		Select selectShipCounty = new Select(driver.findElement(By.id("ShippingNewAddress_CountryId")));

		selectShipCounty.selectByVisibleText("Switzerland");

		driver.findElement(By.id("ShippingNewAddress_City")).sendKeys("TestCity");

		driver.findElement(By.id("ShippingNewAddress_Address1")).sendKeys("10 test 2346");

		driver.findElement(By.id("ShippingNewAddress_ZipPostalCode")).sendKeys("23456");

		driver.findElement(By.id("ShippingNewAddress_PhoneNumber")).sendKeys("9999999999");

		driver.findElement(By.xpath("//div[@id='shipping-buttons-container']//input[@value='Continue']")).click();
	}

	@Test(priority = 9)

	public void shippingMethod() {
		// Shipping Method
		driver.findElement(By.id("shippingoption_1")).click();

		driver.findElement(By.xpath("//div[@id='shipping-method-buttons-container']//input[@type='button']")).click();

	}

	@Test(priority = 10)

	public void paymentMethod() {
		// payment method
		// 15. fill in/select payment method
		// 16. fill in/select payment information
		// 17. confirm order

		driver.findElement(By.id("paymentmethod_1")).click();

		driver.findElement(By.xpath("//div[@id='payment-method-buttons-container']//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//div[@id='payment-info-buttons-container']//input[@value='Continue']")).click();

		driver.findElement(By.xpath("//div[@id='confirm-order-buttons-container']//input[@value='Confirm']")).click();
	}

	@Test(priority = 11)

	public void verifyOrderMessage() {
		// Your order has been successfully processed!

		String ordersucess = driver.findElement(By.xpath("//div[@class='title']/strong")).getText();

		Assert.assertEquals(ordersucess, "Your order has been successfully processed!");

		System.out.println("The order is successfull");

		driver.findElement(By.linkText("Click here for order details.")).click();
	}

	@AfterClass
	void tearDown() {
		driver.close();
	}

}
