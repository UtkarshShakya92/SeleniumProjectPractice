package basics;



import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//import io.github.bonigarcia.wdm.WebDriverManager;

public class OraneHRMLoginTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//WebDriverManager.chromedriver().setup(); 
		//ChromeDriver driver = new ChromeDriver();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		Thread.sleep(5000);
		
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		driver.findElement(By.name("password")).sendKeys("admin");
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();	
		
		/*  ===Title Validation 
		String act_title = driver.getTitle();
		String exp_title = "OrangeHRM";
		
		if(exp_title.equals(act_title))
		{
			System.out.println("Test is passed");
		}
		
		else
		{
			System.out.println("Test is failed");
		}*/
		
		// ===Label validation 
		Thread.sleep(5000);
		
		//String act_label=null;
		String act_label= " "; 
		try{
		 act_label = driver.findElement(By.xpath("//h6[.='Dashboard']")).getText();
		}
		catch(NoSuchElementException e) {}
		
        String exp_label = "Dashboard";
		
		if(exp_label.equals(act_label))
		{
			System.out.println("Test is passed");
		}
		
		else
		{
			System.out.println("Test is failed");
		}
		
		
		driver.quit();
	}

}