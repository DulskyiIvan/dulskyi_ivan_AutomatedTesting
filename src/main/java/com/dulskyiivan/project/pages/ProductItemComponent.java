package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ProductItemComponent {
    private final WebElement element;

    private final By itemTitleLink = By.className("inventory_item_name");
    private final By addToCartButton = By.xpath(".//button[contains(@id, 'add-to-cart')]");
    private final By removeFromCartButton = By.xpath(".//button[contains(@id, 'remove')]");


    public ProductItemComponent(WebElement element) {
        this.element = element;
    }

    public String getItemTitleLink() {
        return element.findElement(itemTitleLink).getText();
    }

    public void openDetails() {
        element.findElement(itemTitleLink).click();
    }

    public void addToCart() {
        element.findElement(addToCartButton).click();
    }

    public void removeFromCart() {
        element.findElement(removeFromCartButton).click();
    }

    public boolean removeFromCartButtonIsDisplayed() {
        return element.findElement(removeFromCartButton).isDisplayed();
    }

    public boolean addToCartButtonIsDisplayed() {
        return element.findElement(addToCartButton).isDisplayed();
    }


}
