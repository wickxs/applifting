package io.applifting.components.mainPage;

import io.applifting.helpers.ElementHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

public class OurWorkComponent extends ElementHelper {

    public OurWorkComponent() {
        super();
    }

    public void verifyOurWorkElementsAreVisible (String OW) {
        Assert.assertTrue(findElementWithRetry(By.xpath("//a[@href='/case-study/" + OW + "']")).isDisplayed());
    }
}
