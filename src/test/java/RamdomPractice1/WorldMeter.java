package RamdomPractice1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*public class WorldMeter {

	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		String xpath_current_pop_data = "//div[@id='maincounter-wrap']//div[@class='maincounter-number']/span";
		String xpath_today_pop = "//div[.='Today']//parent::div//span[@class='rts-counter']";
		String xpath_Thisyear_pop = "//div[.='This year']//parent::div//span[@class='rts-counter']";

		String xpath_TodayandThisYear_pop = "//div[.='Today' or .='This year']//parent::div//span[@class='rts-counter']";

		driver = new ChromeDriver();

		driver.get("https://www.worldometers.info/world-population/");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		int count = 1;
		while (count <= 21) {
			System.out.println(count + "sec");

			if (count == 21)
				break;
			{
				System.out.println("---------current population count-----------");
				printPopulationData(xpath_current_pop_data);

				System.out.println("---------Today and This Year population count-----------");
				// printPopulationData(xpath_today_pop);
				printPopulationData(xpath_TodayandThisYear_pop);

				System.out.println("==================================================");
				
				Thread.sleep(1000);
				count++;
			}
		}
	

	public static void printPopulationData(String locator) {
		
			List<WebElement> Poplist = driver.findElements(By.xpath(locator));

			for (WebElement e : Poplist) {
				System.out.println(e.getText());
			}
	
		}
	}


}
*/