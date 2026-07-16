package com.dulskyiivan.project;

import com.dulskyiivan.project.pages.LoginPage;
import com.dulskyiivan.project.pages.ProductDetailsPage;
import com.dulskyiivan.project.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class CartTests extends BaseTest {

    @BeforeEach
    void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test
    @DisplayName("Successful add two products from different pages")
    public void successfulAddTwoProductsFromDifferentPages() {

        String backpackName = "Sauce Labs Backpack";
        String tShirtName = "Sauce Labs Bolt T-Shirt";

        ProductsPage productsPage = new ProductsPage(driver);

        productsPage.getProductByName(backpackName).addToCart();

        productsPage.getProductByName(tShirtName).openDetails();
        ProductDetailsPage productDetailsPage = new ProductDetailsPage(driver);

        List<String> items = productDetailsPage
                .addToCart()
                .goToCart()
                .getCartItemNames();

        Assertions.assertEquals(2, items.size());
        Assertions.assertTrue(items.contains(tShirtName) && items.contains(backpackName));

    }


}
