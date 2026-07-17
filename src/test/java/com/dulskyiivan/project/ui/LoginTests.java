package com.dulskyiivan.project.ui;

import com.dulskyiivan.project.pages.LoginPage;
import com.dulskyiivan.project.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.Color;

@DisplayName("Login to system")
public class LoginTests extends BaseTest {


    @Test
    @DisplayName("Login fails for locked out user")
    public void test_login_locked_out_user() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("locked_out_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();

        Assertions.assertEquals("#e2231a", Color.fromString(loginPage.getBackgroundColorOfErrorContainer()).asHex(),
                "The background color of the error container does not match the design!");

        Assertions.assertTrue(loginPage.getTextOfErrorContainer().contains("Epic sadface: Sorry, this user has been locked out."),
                "The error container text does not match the expected value!");
    }

    @Test
    @DisplayName("Successful login with valid data")
    public void test_login_valid_data() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");

        String actualColorLoginButton = loginPage.getBackgroundColorOfLoginButton();
        String expectedColorLoginButton = "rgba(61, 220, 145, 1)";
        Assertions.assertEquals(expectedColorLoginButton, actualColorLoginButton,
                "The color of the login button is not as expected");

        loginPage.clickLoginButton();

        ProductsPage productsPage = new ProductsPage(driver);
        Assertions.assertTrue(productsPage.isProductContainerDisplayed(), "The product container is not displayed.");


    }

}
