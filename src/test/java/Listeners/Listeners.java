package Listeners;

import Utilities.Reports;
import Utilities.ScreenShot;
import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Test;

import java.io.IOException;

public class Listeners extends Reports implements ITestListener
{

    ExtentTest test = extent.createTest("Flipkart_Auto");

    @Test
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Started");
        test.info(result.getName());
        try {
            ScreenShot.Screen_Shot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Successful");
        test.info(result.getName());
        try {
            ScreenShot.Screen_Shot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failed");
        test.fail(result.getName());
        try {
            ScreenShot.Screen_Shot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped");
        test.info(result.getName());
        try {
            ScreenShot.Screen_Shot(result.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void onFinish(ITestContext context)
    {
        System.out.println("Test Finished");
        test.info(context.getName());
        try {
            ScreenShot.Screen_Shot(context.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        extent.flush();
    }
}
