package io.applifting;

import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    protected static WebDriver driver;

    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = WebDriverFactory.getDriver();
        driver.manage().window().maximize();
    }

    public static void tearDown() {
        WebDriverFactory.quitDriver();
    }
}