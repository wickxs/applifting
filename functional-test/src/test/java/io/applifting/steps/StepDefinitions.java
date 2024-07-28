package io.applifting.steps;

import io.applifting.WebDriverFactory;
import io.applifting.helpers.Constants;
import io.applifting.helpers.Context;
import io.applifting.helpers.ElementHelper;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;


public class StepDefinitions {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private Context context;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        elementHelper = new ElementHelper(driver);
        context = new Context();
    }

    @After
    public void tearDown() {
//        WebDriverFactory.quitDriver();
    }

    @Given("User is on the homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.applifting.io");
    }

    @Then("Homepage is loaded correctly")
    public void homepageIsLoadedCorrectly() {
        elementHelper.checkElementVisibility(By.xpath("//h1/p[contains(text(), 'Apps fuelled')]"));
        elementHelper.checkElementVisibility(By.xpath("//p[contains(text(), 'PRODUCTS AND SERVICES')]"));
    }

    @Then("Navigation works correctly")
    public void navigationWorksCorrectly() {
        elementHelper.checkElementsVisibility(By.xpath("//nav//a[contains(@class, 'nav-item')]")); //All navigation items except for Services
        elementHelper.checkElementsVisibility(By.xpath("//nav//div/div/div[contains(@class, 'nav-item')]")); //Services navigation item
    }

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        context.setCurrentPage(pageName);
        pageName = elementHelper.transformPageName(pageName);
        WebElement navItem = driver.findElement(By.xpath("//nav//a[contains(@class, 'nav-item') and contains(@href, '" + pageName + "')]"));
        navItem.click();
    }


    @Then("Page is displayed with correct information and text {string}")
    public void pageIsDisplayedWithCorrectInformation(String title) {
        String[] words = title.split(" ");
        StringBuilder xpathBuilder = new StringBuilder("//h1[");

        for (int i = 0; i < words.length; i++) {
            if (i > 0) {
                xpathBuilder.append(" and ");
            }
            xpathBuilder.append("contains(., \"").append(words[i]).append("\")");
        }

        xpathBuilder.append("]");

        String xpath = xpathBuilder.toString();
        elementHelper.waitUntilElementVisible(By.xpath(xpath));
        elementHelper.checkPageTitleContains(context.getCurrentPage());
    }

    @Then("Contact form works correctly")
    public void contactFormWorksCorrectly() {
        elementHelper.fillForm(By.name("name"), Constants.NAME, By.name("email"), Constants.EMAIL, By.name("message"), Constants.MESSAGE, By.xpath("//form//div//p"), By.xpath("//button[text()='Send message']"));
// If sending would be turned on, I would expect some confirmation message, which would be validated here
//        elementHelper.checkElementVisibility(By.id("confirmation-message"));
    }

    @Then("Blog articles are displayed correctly")
    public void blogArticlesAreDisplayedCorrectly() {
        elementHelper.checkElementsVisibility(By.cssSelector(".blog-landing-article-title"));
    }

    @Then("Links to individual blog articles work correctly")
    public void linksToIndividualBlogArticlesWorkCorrectly() {
        List<WebElement> blogLinks = driver.findElements(By.cssSelector(".blog-landing-article-title a"));
        for (WebElement link : blogLinks) {
            link.click();
            elementHelper.checkPageTitleContains("Blog");
            driver.navigate().back();
        }
    }
}