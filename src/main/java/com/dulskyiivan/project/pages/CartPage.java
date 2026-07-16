package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private final WebDriver driver;

    private final By cartItemNamesLocator = By.className("inventory_item_name");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public List<String> getCartItemNames() {
        List<WebElement> items = driver.findElements(cartItemNamesLocator);
        return items.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }


}
