package org.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.utils.ScreenshotUtil;

import java.nio.file.Path;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object instance = result.getInstance();
        if (instance instanceof BaseTest) {
            WebDriver driver = ((BaseTest) instance).getDriver();
            if (driver != null) {
                Path file = ScreenshotUtil.capture(driver, result.getMethod().getMethodName());
                if (file != null) {
                    Reporter.log("Screenshot guardado: " + file.toAbsolutePath(), true);
                }
            }
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("Reportes en target/surefire-reports: index.html, emailable-report.html, testng-results.xml");
    }
}