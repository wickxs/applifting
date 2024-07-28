package io.applifting.reports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import lombok.Setter;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ExtentReportListener {

    private static final ExtentReports extent;
    private static final ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    @Setter
    private static WebDriver driver;

    static {
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("applifting-test-report.html");
        sparkReporter.config().setTheme(Theme.STANDARD);
        extent = new ExtentReports();
        extent.attachReporter(sparkReporter);
    }

    public static void setUp(Scenario scenario) {
        ExtentTest extentTest = extent.createTest(scenario.getName());
        test.set(extentTest);
    }

    public static void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String screenshotBase64 = takeScreenshot();
            test.get().fail("Scenario failed: " + scenario.getName());
            test.get().addScreenCaptureFromBase64String(screenshotBase64, "Failure Screenshot");
        } else {
            test.get().pass( "Scenario passed: " + scenario.getName());
        }
        extent.flush();
    }

    private static String takeScreenshot() {
        TakesScreenshot ts = (TakesScreenshot) driver;
        return ts.getScreenshotAs(OutputType.BASE64);
    }
}