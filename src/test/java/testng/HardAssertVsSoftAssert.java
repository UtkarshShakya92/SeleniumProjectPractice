package testng;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardAssertVsSoftAssert {
  //@Test
  public void HardAssert() {
	  
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  
	  Assert.assertEquals(1, 2);
	  
	  System.out.println("Hard Assertion completed..");
	  
	  Assert.assertEquals(1, 1);
	  
	  
  }
  @Test
public void SoftAssertion() {
	  
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  System.out.println("Testing....");
	  
	  SoftAssert sa =new SoftAssert();
	  
	  sa.assertEquals(1, 2);
	  
	  System.out.println("soft Assertion completed..");
	  
	  Assert.assertEquals(1, 1);
	  
	  sa.assertAll();
  }
}



