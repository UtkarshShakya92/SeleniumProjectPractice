package Page_Object_Model;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Amazonsuggloc {
	
	WebDriver driver;

	//constructor
	
	Amazonsuggloc(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	//locators
	
	@FindBy(id="twotabsearchtextbox")
	WebElement srch_field;
	
	@FindBy(xpath="//div[@id='nav-flyout-searchAjax']//div[@class='s-suggestion-container']")
	List<WebElement> options;
	
	//action Methods
	
	public void searchBox()
	{
		srch_field.sendKeys("Smart TV");
	}
	
	
	
	
}
