package com.dulskyiivan.project;

import com.dulskyiivan.project.pages.LoginPage;
import com.dulskyiivan.project.pages.ProductItemComponent;
import com.dulskyiivan.project.pages.ProductsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ProductCatalogTests extends BaseTest {


    @BeforeEach
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLoginButton();
    }


    @Test
    @DisplayName("Successful sorting by price high to low")
    public void test_product_sorting_by_price_high_to_low() {

        ProductsPage productsPage = new ProductsPage(driver);

        List<ProductItemComponent> productItemComponents = productsPage.sortProductsBy("Price (high to low)")
                .getProductItems();
        double firstProductPrice = productItemComponents.get(0).getPrice();
        double doubleProductPrice = productItemComponents.get(1).getPrice();

        Assertions.assertTrue(firstProductPrice >= doubleProductPrice, "The price of the first product " +
                " must be greater than or equal to the price of the second");
        Assertions.assertEquals(49.99, firstProductPrice, "The most expensive product costs 49.99");
    }

}
