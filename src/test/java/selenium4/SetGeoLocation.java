package selenium4;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class SetGeoLocation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		//55  37
		
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		Map<String,Object> command = new HashMap<String,Object>();
		
		command.put("latitude",40);
		command.put("longitude",3);
		command.put("accuracy",1);
		
		driver.executeCdpCommand("Emulation.setGeolocationOverride", command);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.name("q")).sendKeys("NetFlix",Keys.ENTER);
		
		Thread.sleep(2000);
		driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
		
		String title = driver.findElements(By.cssSelector(".default-ltr-cache-1d3w5wq")).get(0).getText();
		
		System.out.println(title);
	}

}
