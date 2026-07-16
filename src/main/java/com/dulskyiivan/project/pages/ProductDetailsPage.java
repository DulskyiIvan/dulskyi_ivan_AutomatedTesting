package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage {
    private final WebDriver driver;

    private final By productName = By.cssSelector("div[data-test='inventory-item-name']");
    private final By addToCartButton = By.id("add-to-cart");
    private final By removeFromCartButton = By.id("remove");
    private final By shoppingCartLink = By.cssSelector("a[data-test='shopping-cart-link']");
    private final By backToProducts = By.cssSelector("div[data-test='back-to-products']");


    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public ProductDetailsPage addToCart() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    public ProductDetailsPage removeFromCart() {
        driver.findElement(removeFromCartButton).click();
        return this;
    }


    public ProductsPage backToProducts() {
        driver.findElement(backToProducts).click();
        return new ProductsPage(driver);
    }

    public CartPage goToCart() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }


}
