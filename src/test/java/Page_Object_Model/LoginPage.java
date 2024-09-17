package Page_Object_Model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;

	//constructor
	
	LoginPage(WebDriver driver)
	{
		this.driver = driver;		
	}	
	
	//locators 
	
	By txt_username_loc =By.name("username");
	By txt_password_loc =By.name("password");
	By btn_login_loc = By.xpath("//button[.=' Login ']");
	
	//action methods
	
	public void setUserName(String uname)
	{
		driver.findElement(txt_username_loc).sendKeys(uname);
	}
	
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
}
