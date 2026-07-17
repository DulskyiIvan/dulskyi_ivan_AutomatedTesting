package com.dulskyiivan.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private final By productName = By.cssSelector("div[data-test='inventory-item-name']");
    private final By addToCartButton = By.id("add-to-cart");
    private final By removeFromCartButton = By.id("remove");
    private final By shoppingCartLink = By.cssSelector("a[data-test='shopping-cart-link']");
    private final By backToProducts = By.cssSelector("button[data-test='back-to-products']");


    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailsPage addToCart() {
        click(addToCartButton);
        return this;
    }

    public ProductDetailsPage removeFromCart() {
        click(removeFromCartButton);
        return this;
    }

    @Step("Back to products")
    public ProductsPage backToProducts() {
        click(backToProducts);
        return new ProductsPage(driver);
    }
    @Step("Go to cart")
    public CartPage goToCart() {
        click(shoppingCartLink);
        return new CartPage(driver);
    }


}
