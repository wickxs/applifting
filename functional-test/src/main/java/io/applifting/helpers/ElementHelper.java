package io.applifting.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ElementHelper {

    private final WebDriver driver;

    private final WebDriverWait wait;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void checkElementVisibility(By locator) {
        WebElement element = driver.findElement(locator);
        assertTrue(element.isDisplayed());
    }

    public void checkElementsVisibility(By locator) {
        waitUntilElementVisible(locator);
        List<WebElement> elements = driver.findElements(locator);
        assertFalse(elements.isEmpty());
        for (WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkPageTitleContains(String title) {
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Applifting | " + title));
    }

    public void fillForm(By nameLocator, String name, By emailLocator, String email, By messageLocator, String message, By checkboxButtonLocator, By submitButtonLocator) {
        waitUntilElementClickable("//form//input[@name='name']");
        driver.findElement(nameLocator).sendKeys(name);
        driver.findElement(emailLocator).sendKeys(email);
        driver.findElement(messageLocator).sendKeys(message);
        driver.findElement(checkboxButtonLocator).click();
//        driver.findElement(submitButtonLocator).click(); Commented out to prevent spamming your site :)
    }

    public String transformPageName(String pageName) {
        if (pageName == null || pageName.isEmpty()) {
            return pageName;
        }
        return pageName.trim().toLowerCase().replace(" ", "-");
    }

    public void waitUntilElementVisible(By xPath) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(xPath));
    }


    public void waitUntilElementClickable(String xPath) {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xPath)));
    }
}
