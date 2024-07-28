package io.applifting.components.mainPage;

import io.applifting.helpers.ElementHelper;
import org.openqa.selenium.By;

public class NewsletterComponent extends ElementHelper {

    private static final By newsletterSection = By.xpath("//h2[contains(text(), 'Join our newsletter')]");
    private static final By newsletterInput = By.xpath("//input[@placeholder='Business email']");
    private static final By newsletterButton = By.xpath("//button[@type='submit']");

    public NewsletterComponent() {
        super();
    }

    public void checkNewsletterComponent() {
        checkElementVisibility(newsletterSection);
        checkElementVisibility(newsletterInput);
        checkElementVisibility(newsletterButton);
    }
}
