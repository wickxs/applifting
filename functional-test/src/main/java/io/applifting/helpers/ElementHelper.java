package io.applifting.helpers;

import io.applifting.WebDriverFactory;
import lombok.Getter;
import org.openqa.selenium.*;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

@Getter
public class ElementHelper {

    private final WebDriver driver;

    public ElementHelper() {
        this.driver = WebDriverFactory.getDriver();
    }

    public void checkElementVisibility(By locator) {
        WebElement element = findElementWithRetry(locator);
        assertTrue(element.isDisplayed());
    }

    public void checkElementsVisibility(By locator) {
        List<WebElement> elements = findElementsWithRetry(locator);
        assertFalse(elements.isEmpty());
        for (WebElement element : elements) {
            assertTrue(element.isDisplayed());
        }
    }

    public void clickToAcceptCookies(){
        By cookiesLocator = By.xpath("//div[@class='cky-notice-btn-wrapper']//button[@class='cky-btn cky-btn-accept']");
         try {
            WebElement cookies = findElementWithRetry(cookiesLocator);
            cookies.click();
        } catch (NotFoundException ignored) {

         }
    }

    public void checkPageTitleContains(String title) {
        String pageTitle = driver.getTitle();
        assertTrue("Title is: " + pageTitle, pageTitle.contains("Applifting | " + title));
    }

    public void fillForm(String name, String email, String message) {
        findElementWithRetry(By.name("name")).sendKeys(name);
        findElementWithRetry(By.name("email")).sendKeys(email);
        findElementWithRetry(By.name("message")).sendKeys(message);
        WebElement checkbox = findElementWithRetry(By.xpath("//button[@role='checkbox']"));
//        scrollToElement(checkbox);
        checkbox.click();
    }

    public void sendFormAndVerify() {
//        findElementWithRetry(submitButtonLocator).click(); Commented out to prevent spamming your site :)
    }

    public String transformPageName(String pageName) {
        if (pageName == null || pageName.isEmpty()) {
            return pageName;
        }
        return pageName.trim().toLowerCase().replace(" ", "-");
    }

    public WebElement findElementWithRetry(By locator) {
        int attempts = 0;
        int maxRetries = 5;
        while (attempts < maxRetries) {
            try {
                return driver.findElement(locator);
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new NotFoundException("Failed to find element after " + maxRetries + " attempts");
    }

    public List<WebElement> findElementsWithRetry(By locator) {
        int attempts = 0;
        int maxRetries = 100;
        while (attempts < maxRetries) {
            try {
                List<WebElement> elements = driver.findElements(locator);
                if (!elements.isEmpty()) {
                    return elements;
                }
                attempts++;
            } catch (StaleElementReferenceException e) {
                attempts++;
            }
        }
        throw new RuntimeException("Failed to find elements after " + maxRetries + " attempts");
    }

//    public void scrollToElement(WebElement element) {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
//    }
}
