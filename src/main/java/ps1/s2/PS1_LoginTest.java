package ps1.s2;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PracticeExercise.pages.LoginPage;

public class PS1_LoginTest {

    //WebDriver and LoginPage instances
    private WebDriver driver;
    private LoginPage loginPage;

    //Initialize the WebDriver and LoginPage objects before each test method
    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\upend\\eclipse-workspace\\Practice Exercises\\Selenium - S2\\pages\\drivers\\windows\\chromedriver.exe");
        driver = new ChromeDriver();
        loginPage = new LoginPage();
    }

    //Test method for the login functionality
    @Test
    public void testLogin() throws InterruptedException {
        //Navigate to the login page
        driver.get("https://www.facebook.com/");

        //Enter the username, password, and click the login button
        loginPage.enterUsername("Admin");
        Thread.sleep(5000);
        loginPage.enterPassword("admin123");
        Thread.sleep(5000);
        loginPage.clickLogin();

        //Verify the expected result after logging in
        Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
    }

    //Close the browser after each test method
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}




