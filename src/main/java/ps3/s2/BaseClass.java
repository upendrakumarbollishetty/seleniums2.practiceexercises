package ps3.s2;

import java.io.File;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;

	public static void initialize() throws InterruptedException {
		driver = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\upend\\eclipse-workspace\\Practice Exercises\\Selenium - S2\\pages\\drivers\\windows\\chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		Thread.sleep(5000);
		driver.get("https://www.youtube.com/");
		Thread.sleep(10000);

	}

	public void captureScreenshot(String methodname)
	{
		Date d = new Date();
		String timestamp = d.toString().replace(":","_").replace(" ", "");
		System.out.println(timestamp);
		try 
		{
			File file =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(file, new File("C:\\Users\\upend\\eclipse-workspace\\Practice Exercises\\Selenium - S2\\pages\\screenshotsfolder"+methodname+timestamp+".jpg"));
	}
		catch(Exception e) {
			e.getMessage();
		}
	

}
}
