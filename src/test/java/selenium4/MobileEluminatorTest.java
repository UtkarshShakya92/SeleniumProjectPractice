package selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;
import java.util.*;

public class MobileEluminatorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		 
		ChromeDriver driver = new ChromeDriver();
		
		DevTools devTools = driver.getDevTools();
		
		devTools.createSession();
		
		//devTools.send(Enumeration.setDeviceMetricsOverride(430, 932, 100, true, java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty(), java.util.Optional.empty()));
		
		devTools.send(Emulation.setDeviceMetricsOverride(430, 932, 100, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.xpath("//button//span[@class='navbar-toggler-icon']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(@href,'library')]")).click();
	}

}
