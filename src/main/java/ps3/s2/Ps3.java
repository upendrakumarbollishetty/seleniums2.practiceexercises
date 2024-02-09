package ps3.s2;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class Ps3  implements ITestListener {

    // Get the WebDriver instance from your test class
    private WebDriver driver;

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("Test Failed: " + result.getName());

        // Take screenshot on test failure
        if (driver != null) {
            try {
                // Convert WebDriver object to TakesScreenshot
                TakesScreenshot ts = (TakesScreenshot) driver;

                // Capture the screenshot as File
                File screenshotFile = ts.getScreenshotAs(OutputType.FILE);

                // Define the destination path to save the screenshot
                String destPath = "screenshots/" + result.getName() + "_failure.png";

                // Copy the screenshot to the destination path
                FileUtils.copyFile(screenshotFile, new File(destPath));

                System.out.println("Screenshot captured: " + destPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Implement other methods of ITestListener as needed

    @Override
    public void onStart(ITestContext context) {
        // Initialize or setup code can be placed here
    }

    @Override
    public void onFinish(ITestContext context) {
        // Cleanup or teardown code can be placed here
    }

    // Other methods like onTestStart, onTestSuccess, etc., can be implemented as per your requirement
}


