package io.applifting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.After;
import org.junit.Before;

public class BaseTest {
    protected WebDriver driver;

    @Before
    public void setUp() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.online-shopping.com");
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

