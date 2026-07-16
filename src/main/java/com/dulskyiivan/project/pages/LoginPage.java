package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private static final By usernameField = By.cssSelector("[data-test='username']");
    private static final By passwordField = By.xpath("//input[@type='password']");
    private static final By loginButton = By.name("login-button");

    private static final By errorContainer = By.cssSelector("div[class='error-message-container error']");
    private final WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        WebElement element = driver.findElement(usernameField);
        element.clear();
        element.sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getBackgroundColorOfLoginButton() {
        return driver.findElement(loginButton).getCssValue("background-color");
    }

    public String getBackgroundColorOfErrorContainer() {
        return driver.findElement(errorContainer).getCssValue("background-color");
    }

    public String getTextOfErrorContainer() {
        return driver.findElement(errorContainer).getText();
    }

    public boolean loginContainerIsDisplayed() {
        return driver.findElement(By.cssSelector("div[class='login_container']")).isDisplayed();
    }
}
