package basics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handlebootstrapdrpdwn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		 //driver.findElements(By.xpath("//select[@id='country']//option"));
		
		List<WebElement> options =driver.findElements(By.xpath("//select[@id='country']//option"));
		
	    System.out.println("Total no of options :"+options.size());
	    
	    //print all the optons list 
	   
	    /*
	    for(int i=0;i<options.size();i++)
	    {
	    	System.out.println(options.get(i).getText());
	    }
            */
	    
	    //selecting one value from dropdown
	    
	    JavascriptExecutor js = (JavascriptExecutor)driver;
	    
	    js.executeScript("window.scrollTo(0,710)");
	    
	    /*for(int i=0;i<options.size();i++)
	    {
	    	if(options.get(i).getText().equals("Australia"))
	    	{
	    		options.get(i).click();
	    		break;
	    	}
	    }
	    */
	    
	    for(WebElement opt :options)
	    {
	    	if(opt.getText().equals("France"))
	    	{
	    		opt.click();
	    		break;
	    	}
	    }
	    
	    
	    
	    
	}

}
