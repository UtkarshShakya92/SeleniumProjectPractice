package selenium4;

import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v131.network.Network;
import org.openqa.selenium.devtools.v131.network.model.Request;
import org.openqa.selenium.devtools.v131.network.model.Response;

//import com.google.common.graph.Network;

public class NetworkLogActivity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeDriver driver = new ChromeDriver();
		
		DevTools  devTools =  driver.getDevTools();
		
		devTools.createSession();
		
		//Log file ---->
		devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
		
		//Event fired :  addListeners and Network Request
		
		devTools.addListener(Network.requestWillBeSent(), request ->
		{
			Request req = request.getRequest();
			
			System.out.println(req.getUrl());
			
			System.out.println(req.getHeaders());
		}
		);
		
		//Event fired :  addListeners and Network response
		
		devTools.addListener(Network.responseReceived(), response ->
		
		{
			Response res = response.getResponse();
			
			System.out.println(res.getStatus());
			
			System.out.println(res.getUrl());
		}		);
		
		driver.get("https://rahulshettyacademy.com/angularAppdemo/");
		
		driver.findElement(By.cssSelector("button[routerlink='/library']")).click();
	}

}
