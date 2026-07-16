package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenuComponent {
    private static final By burgerMenuButton = By.id("react-burger-menu-btn");
    private static final By logoutButton = By.id("logout_sidebar_link");
    WebDriver driver;

    public BurgerMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    public BurgerMenuComponent clickBurgerMenuButton() {
        driver.findElement(burgerMenuButton).click();
        return this;
    }

    public LoginPage clickLogoutButton() {
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}
