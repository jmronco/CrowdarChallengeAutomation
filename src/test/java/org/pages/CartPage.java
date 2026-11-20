package org.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import static org.constants.Constants.INVENTORY_URL;

public class CartPage extends BasePage {

    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    private WebElement addBackPackBtn;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    private WebElement addBikeLightBtn;

    @FindBy(css = "[data-test='shopping-cart-badge']")
    private WebElement cartBadge;

    @FindBy(id = "remove-sauce-labs-backpack")
    private WebElement removeBackPackBtn;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProducts() {
        wait.until(ExpectedConditions.urlToBe(INVENTORY_URL));
        wait.until(ExpectedConditions.visibilityOf(addBackPackBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addBackPackBtn));
        addBackPackBtn.click();
        wait.until(ExpectedConditions.visibilityOf(addBikeLightBtn));
        wait.until(ExpectedConditions.elementToBeClickable(addBikeLightBtn));
        addBikeLightBtn.click();
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        Assert.assertEquals(cartBadge.getText(), "2");
    }

    public void deleteProduct() {
        wait.until(ExpectedConditions.urlToBe(INVENTORY_URL));
        wait.until(ExpectedConditions.visibilityOf(removeBackPackBtn));
        wait.until(ExpectedConditions.elementToBeClickable(removeBackPackBtn));
        removeBackPackBtn.click();
        wait.until(ExpectedConditions.visibilityOf(cartBadge));
        Assert.assertEquals(cartBadge.getText(), "1");
    }
}
