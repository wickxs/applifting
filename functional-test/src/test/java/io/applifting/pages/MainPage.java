package io.applifting.pages;

import io.applifting.components.mainPage.GetInTouchComponent;
import io.applifting.components.mainPage.NewsletterComponent;
import io.applifting.components.mainPage.OurWorkComponent;
import io.applifting.components.mainPage.ProductAndServicesComponent;
import io.applifting.helpers.ElementHelper;
import org.openqa.selenium.By;

public class MainPage extends ElementHelper {

    private final NewsletterComponent newsletterComponent;
    private final GetInTouchComponent getInTouchComponent;

    private final ProductAndServicesComponent productAndServicesComponent;

    private final OurWorkComponent ourWorkComponent;

    private static final By mainPageTitleLocator = By.xpath("//h1/p[contains(text(), 'Apps fuelled')]");
    private static final By mainPageProductsAndServicesTitle = By.xpath("//h1/p[contains(text(), 'Apps fuelled')]");
    private static final By navigationItems = By.xpath("//nav//a[contains(@class, 'nav-item')]");
    private static final By servicesItem = By.xpath("//nav//div/div/div[contains(@class, 'nav-item')]");
    private static final By getInTouchButton = By.xpath("//a[contains(text(), 'GET IN TOUCH')]");
    private static final By ourWorkSection = By.xpath("//h2[contains(text(), 'Our Work')]");

    public MainPage() {
        super();
        this.newsletterComponent = new NewsletterComponent();
        this.getInTouchComponent = new GetInTouchComponent();
        this.productAndServicesComponent = new ProductAndServicesComponent();
        this.ourWorkComponent = new OurWorkComponent();
    }

    public void checkNavigation() {
        checkElementsVisibility(navigationItems);
        checkElementsVisibility(servicesItem);
    }
    public void checkMainPageComponents() {
        checkElementVisibility(mainPageTitleLocator);
        checkElementVisibility(mainPageProductsAndServicesTitle);
        checkElementVisibility(getInTouchButton);
        checkElementVisibility(ourWorkSection);
        newsletterComponent.checkNewsletterComponent();
        getInTouchComponent.checkGetInTouchSection();
    }

    public void productAndServicesVerification(String component) {
        productAndServicesComponent.verifyProductsAndServicesAreVisible(component);
    }

    public void ourWorkVerification(String component) {
        ourWorkComponent.verifyOurWorkElementsAreVisible(component);
    }
}
