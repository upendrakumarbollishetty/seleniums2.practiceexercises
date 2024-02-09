package ps3.s2;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase1  extends BaseClass{
	
	@BeforeTest
	public void setup() throws InterruptedException {
		initialize();
	}
	@Test
	public void testMethod1() 
	{
		driver.findElement(null);
	}
	@AfterTest
	public void teardown() 
	{
		driver.quit();
	}
	
	
	

}
