package io.applifting.steps;

import io.applifting.WebDriverFactory;
import io.applifting.helpers.Context;
import io.applifting.helpers.ElementHelper;
import io.applifting.pages.MainPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class StepDefinitions {

    private WebDriver driver;
    private ElementHelper elementHelper;
    private Context context;
    private MainPage mainPage;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        elementHelper = new ElementHelper();
        context = new Context();
        mainPage = new MainPage();
    }

    @After
    public void tearDown() {
        WebDriverFactory.quitDriver();
    }

    @Given("User is on the homepage")
    public void userIsOnHomepage() {
        driver.get("https://www.applifting.io");
    }

    @And("Accepts cookies")
    public void acceptCookies() {
        elementHelper.clickToAcceptCookies();
    }

    @Then("Homepage is loaded correctly")
    public void homepageIsLoadedCorrectly() {
        mainPage.checkMainPageComponents();
    }

    @Then("Navigation works correctly")
    public void navigationWorksCorrectly() {
        mainPage.checkNavigation();
    }

    @Given("Check {string} in {string} components on main page")
    public void checkProductAndServices(String component, String PAS) {
        if (component.contains("products")) {
            mainPage.productAndServicesVerification(PAS);
        } else if (component.contains("work")){
            mainPage.ourWorkVerification(PAS);
        } else {
            throw new IllegalArgumentException("Unsupported value.");
        }
    }

    @When("User navigates to {string} page")
    public void userNavigatesToPage(String pageName) {
        context.setCurrentPage(pageName);
        pageName = elementHelper.transformPageName(pageName);
        WebElement navItem = elementHelper.findElementWithRetry(By.xpath("//nav//a[contains(@class, 'nav-item') and contains(@href, '" + pageName + "')]"));
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
        elementHelper.checkElementVisibility(By.xpath(xpath));
        elementHelper.checkPageTitleContains(context.getCurrentPage());
    }

    @And("Fills out the form for mandatory fields {string}, {string}, {string} and clicks consent")
    public void fillOutForm(String name, String email, String message) {
        elementHelper.fillForm(name, email, message);
    }

    @Then("Contact form works correctly")
    public void contactFormWorksCorrectly() {
        elementHelper.sendFormAndVerify();
        // If sending would be turned on, I would expect some confirmation message, which would be validated here
        //        elementHelper.checkElementVisibility(By.id("confirmation-message"));
    }

    @Then("Blog articles are displayed correctly")
    public void blogArticlesAreDisplayedCorrectly() {
        elementHelper.checkElementsVisibility(By.xpath("//div[contains(@class, 'blog-landing-article-title')]"));
    }
}