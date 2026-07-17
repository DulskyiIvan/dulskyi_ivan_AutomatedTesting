package com.dulskyiivan.project.ui;

import com.dulskyiivan.project.pages.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
@DisplayName("Add/remove to cart")
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

    @Test
    @DisplayName("Successful add and remove product on product page")
    public void test_add_and_remove_product_on_product_page() {
        String backpackName = "Sauce Labs Backpack";
        ProductsPage productsPage = new ProductsPage(driver);

        ProductItemComponent product = productsPage.getProductByName(backpackName);
        product.addToCart();

        Assertions.assertTrue(product.removeFromCartButtonIsDisplayed());
        Assertions.assertEquals("1", productsPage.getShoppingCartBadgeText());

        product.removeFromCart();

        Assertions.assertTrue(product.addToCartButtonIsDisplayed());
        Assertions.assertFalse(productsPage.isShoppingCartBadgeDisplayed());


    }

    @Test
    @DisplayName("Successful remove product directly from cart page")
    public void test_remove_product_directly_from_cart_page() {
        String backpackName = "Sauce Labs Backpack";

        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.getProductByName(backpackName).addToCart();


        Assertions.assertTrue(productsPage.goToCart()
                        .removeFromCart()
                        .isCartEmpty()
                , "The cart must be empty after the product is released.");


    }


}
