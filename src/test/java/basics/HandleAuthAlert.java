package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthAlert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      
        WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/digest_auth");
		
		
		//https://the-internet.herokuapp.com/digest_auth
	}

}
