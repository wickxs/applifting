package io.applifting.components.mainPage;

import io.applifting.helpers.ElementHelper;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ProductAndServicesComponent extends ElementHelper {

    public ProductAndServicesComponent() {
        super();
    }

    public void verifyProductsAndServicesAreVisible (String PAS) {
        Assert.assertTrue(findElementWithRetry(By.xpath("//h2[contains(text(), '" + PAS + "')]")).isDisplayed());
    }
}
