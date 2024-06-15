package TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Resources.ReportGeneration;

public class Listeners extends BaseTest implements ITestListener {
    
    ExtentReports extent = ReportGeneration.getReportObjects(); // ExtentReports object to manage report generation
    ExtentTest test; // ExtentTest object to manage test-specific information
    
    // ThreadLocal to handle concurrent issues in multi-threaded execution
    ThreadLocal<ExtentTest> extentTest =  new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName()); // Create a new test in the report
        extentTest.set(test); // Set the test in ThreadLocal to ensure thread safety
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        try {
            // Retrieve WebDriver instance from the test class using reflection
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(), driver); // Capture screenshot on success
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName()); // Attach screenshot to report

        extentTest.get().log(Status.PASS, "Test Passed"); // Log test status as passed
    }

    @Override
    public void onTestFailure(ITestResult result) {
        extentTest.get().fail(result.getThrowable()); // Log test failure and exception

        try {
            // Retrieve WebDriver instance from the test class using reflection
            driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        String filePath = null;
        try {
            filePath = getScreenShot(result.getMethod().getMethodName(), driver); // Capture screenshot on failure
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        extentTest.get().addScreenCaptureFromPath(filePath, result.getMethod().getMethodName()); // Attach screenshot to report
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush(); // Flush ExtentReports to generate and finalize the report
    }

}