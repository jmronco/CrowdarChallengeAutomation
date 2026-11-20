package org.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import static org.constants.Constants.*;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private WebElement username;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "login-button")
    private WebElement loginBtn;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement lockedUserMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void openLoginPage() {
        driver.get(BASE_URL);
    }

    public void checkHomePage(){
        wait.until(ExpectedConditions.urlToBe(INVENTORY_URL));
        Assert.assertEquals(driver.getCurrentUrl(),INVENTORY_URL);
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(USERNAME);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(PASSWORD);
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(loginBtn));
    }



    public void loginLockedUser() {
        wait.until(ExpectedConditions.visibilityOf(username));
        username.sendKeys(LOCKED_USER);
        wait.until(ExpectedConditions.visibilityOf(password));
        password.sendKeys(PASSWORD);
        wait.until(ExpectedConditions.visibilityOf(loginBtn));
        wait.until(ExpectedConditions.elementToBeClickable(loginBtn));
        loginBtn.click();
        Assert.assertEquals(driver.getCurrentUrl(),BASE_URL);
        wait.until(ExpectedConditions.visibilityOf(lockedUserMessage));
        Assert.assertEquals(lockedUserMessage.getText(),LOCKED_USER_ERROR_MESSAGE);
    }
}
