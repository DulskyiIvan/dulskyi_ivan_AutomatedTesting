package com.dulskyiivan.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends BasePage {

    private final By cartItemNamesLocator = By.className("inventory_item_name");
    private final By removeFromCartButtonLocator = By.xpath(".//button[contains(@id,'remove')]");

    public CartPage(WebDriver driver) {
        super(driver);
    }
    @Step("get Cart Item Names")
    public List<String> getCartItemNames() {
        List<WebElement> items = findElements(cartItemNamesLocator);
        return items.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    @Step("Remove from cart ")
    public CartPage removeFromCart() {
        click(removeFromCartButtonLocator);
        return this;
    }

    public boolean isCartEmpty() {
        setTimeout(0);
        boolean isEmpty = findElements(cartItemNamesLocator).isEmpty();
        setTimeout(10);
        return isEmpty;
    }


}
