package org.tests;

import org.pages.CartPage;
import org.pages.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SauceDemoTests extends BaseTest {
    private LoginPage loginPage;
    private CartPage cartPage;

    @BeforeMethod
    public void initPages() {
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
    }
    @Test
    public void validLogin(){
        loginPage.openLoginPage();
        loginPage.login();
        loginPage.checkHomePage();
    }

    @Test
    public void invalidLogin() {
        loginPage.openLoginPage();
        loginPage.loginLockedUser(); //Valor anterior de errorMessage: "Epic sadface: Sorry, this user has been locked out."
    }                                                          //Se reemplazó para que falle intencionalmente

    @Test
    public void addTwoProducts() {
        validLogin();
        cartPage.addProducts();
    }

    @Test
    public void removeProducts() {
        validLogin();
        addTwoProducts();
        cartPage.deleteProduct();
    }
}
