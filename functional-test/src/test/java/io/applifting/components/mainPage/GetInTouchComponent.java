package io.applifting.components.mainPage;

import io.applifting.helpers.ElementHelper;
import org.openqa.selenium.By;

public class GetInTouchComponent extends ElementHelper {

    private static final By newsletterSection = By.xpath("//h2[contains(text(), 'Get in touch')]");
    private static final By newsletterNameInput = By.xpath("//input[@name='name']");
    private static final By newsletterEmailInput = By.xpath("//input[@name='email']");
    private static final By newsletterHowCanWeHelpInput = By.xpath("//textarea[@name='message']");
    private static final By newsletterCheckbox = By.xpath("//button[@role='checkbox']");
    private static final By newsletterSendMessageButton = By.xpath("//button[contains(., 'Send message')]");

    public GetInTouchComponent() {
        super();
    }

    public void checkGetInTouchSection() {
        checkElementVisibility(newsletterSection);
        checkElementVisibility(newsletterNameInput);
        checkElementVisibility(newsletterEmailInput);
        checkElementVisibility(newsletterHowCanWeHelpInput);
        checkElementVisibility(newsletterCheckbox);
        checkElementVisibility(newsletterSendMessageButton);
    }
}
