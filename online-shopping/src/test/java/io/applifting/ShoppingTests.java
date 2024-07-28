package io.applifting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class ShoppingTests extends BaseTest {

    @Test
    public void searchItems() {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("valid item");
        searchBox.sendKeys(Keys.RETURN);
        List<WebElement> items = driver.findElements(By.className("item"));
        assertFalse("No items found", items.isEmpty());
    }

    @Test
    public void searchNoResults() {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("nonexistent item");
        searchBox.sendKeys(Keys.RETURN);
        WebElement noResultsMessage = driver.findElement(By.id("no-results"));
        assertEquals("Položky nenalezeny", noResultsMessage.getText());
    }

    @Test
    public void browseCategories() {
        driver.findElement(By.linkText("Kategorie")).click();
        List<WebElement> items = driver.findElements(By.className("item"));
        assertFalse("No items found in category", items.isEmpty());
    }

    @Test
    public void addToCart() {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.sendKeys("valid item");
        searchBox.sendKeys(Keys.RETURN);
        driver.findElement(By.className("item")).click();
        driver.findElement(By.id("add-to-cart")).click();
        WebElement cartMessage = driver.findElement(By.id("cart-confirmation"));
        assertEquals("Položka byla přidána do košíku", cartMessage.getText());
    }

    @Test
    public void viewCart() {
        driver.findElement(By.id("cart")).click();
        List<WebElement> cartItems = driver.findElements(By.className("cart-item"));
        assertFalse("Cart is empty", cartItems.isEmpty());
    }

    @Test
    public void updateCart() {
        driver.findElement(By.id("cart")).click();
        WebElement quantityBox = driver.findElement(By.name("quantity"));
        quantityBox.clear();
        quantityBox.sendKeys("2");
        driver.findElement(By.id("update-cart")).click();

        WebElement totalPriceElement = driver.findElement(By.id("total-price"));
        String totalPriceText = totalPriceElement.getText();

        String expectedTotalPrice = "100 Kč";

        assertEquals("Total price did not update correctly", expectedTotalPrice, totalPriceText);
    }

    @Test
    public void completePurchase() {
        driver.findElement(By.id("cart")).click();
        driver.findElement(By.id("checkout")).click();
        WebElement addressBox = driver.findElement(By.name("address"));
        addressBox.sendKeys("123 Main St");
        WebElement paymentBox = driver.findElement(By.name("payment"));
        paymentBox.sendKeys("4111111111111111");
        driver.findElement(By.id("complete-purchase")).click();
        WebElement confirmationMessage = driver.findElement(By.id("order-confirmation"));
        assertEquals("Objednávka byla úspěšně dokončena", confirmationMessage.getText());
    }
}