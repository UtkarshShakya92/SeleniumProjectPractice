package basics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticWebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver = new ChromeDriver(); 
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//find total number of  rows :
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		System.out.println("No of rows :"+ rows);
		
		//find total number of coloums
		
		int col = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		System.out.println("No of cols :"+ col);
		
		//Read specific row and colum data
		/*
		String rowcolvalue =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Value fo 5th row and 1 column is : "+rowcolvalue);
		*/
		
		/*
		//Read All data from rows and coloumn
		
		for(int r=2;r<=rows;r++)
		{
			for(int c=1;c<=col;c++)
			{
				String rowcolvalue =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(rowcolvalue +"       ");
			}
			
			System.out.println();
		}  */
		
		// Print book names whose author is Amit
		
		 /*for(int r=2;r<=rows;r++)
		 {
			 String Author =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			 
			 if(Author.equals("Amit"))
			 {
				 String BookName =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				 
				 System.out.println(Author+"   "+BookName);
			 }*/
			 
		     int sum = 0;
			 for(int r=2;r<=rows;r++)
			 {
				 String price =driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
				 
				  sum =sum+ Integer.parseInt(price);
				 
				 }
			 System.out.println("Total price of books:"+sum);
			 
		 }
		 
		 
		
	}

