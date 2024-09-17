package testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertion {
	
  @Test
  public void test() {
	  
	  int x=10;
	  int y=15;
	  
	  /*if(x==y)
	  {
		  System.out.println("Test is passed");
	  }
	  else
	  {
		  System.out.println("Test is failed");
	  }*/
	  
	  Assert.assertEquals(x,y);
  }
}
