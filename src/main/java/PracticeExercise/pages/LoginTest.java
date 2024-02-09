package PracticeExercise.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {
	public static void main(String[] args) throws InterruptedException {
		
	
	
	WebDriver driver = new ChromeDriver();
	System.setProperty("webdriver.chrome.drive","C:\\Users\\upend\\eclipse-workspace\\Practice Exercises\\Selenium - S2\\pages\\drivers\\windows\\chromedriver.exe");
	driver.get("https://www.facebook.com/");
	//maximize the window
	driver.manage().window().maximize();
	//open facebook and enter email,password
	driver.findElement(By.id("email")).sendKeys("7865124352");
//	wait for some seconds
	Thread.sleep(1000);
	driver.findElement(By.name("pass")).sendKeys("7523698741");
	driver.findElement(By.name("login")).click();	

}

	

}
