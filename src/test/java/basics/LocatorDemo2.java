package basics;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.automationpractice.pl/index.php");
		
		//no of sliders
		List<WebElement> sliders= driver.findElements(By.className("homeslider-container"));
		System.out.println("Number of Sliders Present:"+sliders.size());
		
		//no of images present
		
		 List<WebElement> images = driver.findElements(By.tagName("img"));
		 System.out.println("Number of images present :"+images.size());
		 
		 //links present 
		 List<WebElement> links = driver.findElements(By.tagName("a"));
		 System.out.println("Number of links present :"+links.size());
		 
		 driver.quit();
		
		
		//http://www.automationpractice.pl/index.php

	}

}
