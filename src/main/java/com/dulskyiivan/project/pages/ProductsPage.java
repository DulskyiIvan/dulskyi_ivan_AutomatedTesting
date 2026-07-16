package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private static final By productContainer = By.id("inventory_container");
    private final BurgerMenuComponent burgerMenuComponent;
    private final WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        burgerMenuComponent = new BurgerMenuComponent(driver);
    }

    public BurgerMenuComponent getBurgerMenuComponent() {
        return burgerMenuComponent;
    }

    public boolean isProductContainerDisplayed() {
        return driver.findElement(productContainer).isDisplayed();
    }
}
