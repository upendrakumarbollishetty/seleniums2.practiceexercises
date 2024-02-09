package ps3.s2;

import org.testng.ITestListener;
import org.testng.ITestResult;
//import org.testng.annotations.Listeners;

//@Listeners(ps3.s2.ListenerClass.class)
public class ListenerClass extends BaseClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failed");
		try {
			captureScreenshot(result.getName());
		}
		catch (Exception e) {
			e.getMessage();
		}
	}
	

}
