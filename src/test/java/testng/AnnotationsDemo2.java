package testng;

import org.testng.annotations.*;
import org.testng.annotations.Test;

public class AnnotationsDemo2 {
  @BeforeClass
  public void  login() {
	  
	  System.out.println("Login....");
  }
  
  @Test(priority=1)
  public void Search()
  {
	  System.out.println("Search....");
  }
  
  @Test(priority=2)
  public void AdvanceSearch()
  {
	  System.out.println("AdvanceSearch....");
  }
  
  @AfterClass
  public void Logout()
  {
	  System.out.println("logout....");
  }
}
