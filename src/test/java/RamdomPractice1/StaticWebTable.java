package RamdomPractice1;

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
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		// count number of rows 
		
		int rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size(); // 7
		
		System.out.println("no of rows preset:"+ rows);
		//count no of colums 
		
		int cols = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		System.out.println("no of cols present :"+ cols);
		
	
	/*	//read specific rows and colum data
		
		String bookName =driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Bookame is :" + bookName);
		
		*/
		//read data from all rows and colms
		
		for (int r=2; r<=rows; r++)
		{
			
			for(int c =1;c<=cols;c++)
			{
				String Val = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td["+c+"]")).getText();
				System.out.print(Val+"\t");
			}
			System.out.println();
		}
		
		//print book name whose authr is Amit
		
		for(int r=2; r<=rows; r++)
		{
			String author = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(author.equals("Amit"))
			{
				String BookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(BookName +"     " + author);
			}
			
		}
		
		// print sum of prices of all books
		
		int totalprice =0;
		for(int r=2; r<=rows;r++)
		{
			String prices = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			totalprice = totalprice+Integer.parseInt(prices);
					
		}
		System.out.println("total prices : "+ totalprice);
	}

}
