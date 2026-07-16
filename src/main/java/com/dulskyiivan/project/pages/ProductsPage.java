package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage {

    private static final By productContainer = By.id("inventory_container");
    private final By productItemsLocator = By.className("inventory_item");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
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

    public ProductItemComponent getProductByName(String productName) {
        return getProductItems().stream()
                .filter(p -> p.getItemTitleLink().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    private List<ProductItemComponent> getProductItems() {
        List<WebElement> elements = driver.findElements(productItemsLocator);
        return elements.stream()
                .map(ProductItemComponent::new)
                .collect(Collectors.toList());
    }

    public CartPage goToCart() {
        driver.findElement(shoppingCartLink).click();
        return new CartPage(driver);
    }

    public boolean isShoppingCartBadgeDisplayed() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));

        boolean isPresent = !driver.findElements(shoppingCartBadge).isEmpty();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return isPresent;
    }

    public String getShoppingCartBadgeText() {
        return driver.findElement(shoppingCartBadge).getText();
    }


}
