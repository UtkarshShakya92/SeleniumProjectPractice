package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage2 {
	
	WebDriver driver ;
	//Constructor
	
	LoginPage2(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); ///Mandatory
	}
			
	
	// Locators 
      
	@FindBy(name="username") 
	WebElement txt_username; 
	
	@FindBy(name="password") 
	WebElement txt_password; 
	
	@FindBy(xpath="//button[.=' Login ']")
	WebElement btn_login;
	
	/// Action methods
	
	public void setUserName(String uname)
	{
		txt_username.sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btn_login.click();
	}
}
