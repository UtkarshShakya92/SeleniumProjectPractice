package selenium4;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.emulation.Emulation;

public class ExecuteCdpCommand {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();

		DevTools devTools = driver.getDevTools();

		devTools.createSession();

		Map deviceMetric = new HashMap();

		deviceMetric.put("width", 600);
		deviceMetric.put("height", 1000);
		deviceMetric.put("deviceScaleFactor", 50);
		deviceMetric.put("mobile", true);

		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetric);

		driver.get("https://rahulshettyacademy.com/angularAppdemo/");

		driver.findElement(By.xpath("//button//span[@class='navbar-toggler-icon']")).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath("//a[contains(@href,'library')]")).click();

	}

}
