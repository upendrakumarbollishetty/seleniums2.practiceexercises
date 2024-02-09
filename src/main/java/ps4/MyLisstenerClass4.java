package ps4;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyLisstenerClass4 implements ITestListener {

    private ExtentReports extentReports;

    @Override
    public void onStart(ITestContext context) {
        // Initialize ExtentReports and ExtentSparkReporter
        ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
        extentReports = new ExtentReports();
        extentReports.attachReporter(htmlReporter);
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush and close the report
        extentReports.flush();
//        extentReports.close();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure status to the report
        extentReports.createTest(result.getName()).log(Status.FAIL, "Test Failed");
    }

    // Other overridden methods can be left empty or implemented as needed

    // Capture environment details (you can customize this further)
    private String getEnvironmentDetails() {
        String osName = System.getProperty("os.name");
        String javaVersion = System.getProperty("java.version");
        String hostname = System.getenv("COMPUTERNAME"); // Windows hostname
        String browser = "Chrome"; // You can customize this based on your test setup

        return String.format("OS: %s | Java Version: %s | Hostname: %s | Browser: %s",
                osName, javaVersion, hostname, browser);
    }
}



    