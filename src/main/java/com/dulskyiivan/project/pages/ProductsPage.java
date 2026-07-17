package com.dulskyiivan.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ProductsPage extends BasePage {

    private static final By productContainer = By.id("inventory_container");
    private final By productItemsLocator = By.className("inventory_item");
    private final By shoppingCartLink = By.className("shopping_cart_link");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    public final By selectSortContainer = By.className("product_sort_container");
    private final BurgerMenuComponent burgerMenuComponent;

    public ProductsPage(WebDriver driver) {
        super(driver);
        burgerMenuComponent = new BurgerMenuComponent(driver);
    }

    public BurgerMenuComponent getBurgerMenuComponent() {
        return burgerMenuComponent;
    }

    public boolean isProductContainerDisplayed() {
        return isDisplayed(productContainer);
    }

    public ProductItemComponent getProductByName(String productName) {
        return getProductItems().stream()
                .filter(p -> p.getItemTitleLink().equalsIgnoreCase(productName))
                .findFirst()
                .orElse(null);
    }

    public List<ProductItemComponent> getProductItems() {
        List<WebElement> elements = findElements(productItemsLocator);
        return elements.stream()
                .map(ProductItemComponent::new)
                .collect(Collectors.toList());
    }

    @Step("Go to cart")
    public CartPage goToCart() {
        click(shoppingCartLink);
        return new CartPage(driver);
    }

    public boolean isShoppingCartBadgeDisplayed() {
        setTimeout(0);

        boolean isPresent = !findElements(shoppingCartBadge).isEmpty();
        setTimeout(10);

        return isPresent;
    }

    public String getShoppingCartBadgeText() {
        return getText(shoppingCartBadge);
    }

    @Step("Sort product by")
    public ProductsPage sortProductsBy(String option) {
        Select select = new Select(find(selectSortContainer));
        select.selectByVisibleText(option);
        return this;
    }


}
