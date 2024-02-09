package listenerpractice;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestClass implements ITestListener {

    private WebDriver driver; // Assuming you have a WebDriver instance

    @Override
    public void onTestFailure(ITestResult result) {
        // Take a screenshot on test failure
        if (driver != null) {
            try {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                String screenshotPath = "path/to/screenshots/" + result.getName() + ".png"; // Specify your desired path
                FileUtils.copyFile(screenshotFile, new File(screenshotPath));
                System.out.println("Screenshot saved: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

    // 




	

