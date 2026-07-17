package com.dulskyiivan.project.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private static final By usernameField = By.cssSelector("[data-test='username']");
    private static final By passwordField = By.xpath("//input[@type='password']");
    private static final By loginButton = By.name("login-button");
    private final By loginContainer = By.cssSelector("div[class='login_container']");

    private static final By errorContainer = By.cssSelector("div[class='error-message-container error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Enter username")
    public void enterUsername(String username) {
        type(usernameField, username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        type(passwordField, password);
    }

    @Step("Click login button ")
    public void clickLoginButton() {
        click(loginButton);
    }

    public String getBackgroundColorOfLoginButton() {
        return getBackgroundColor(loginButton);
    }

    public String getBackgroundColorOfErrorContainer() {
        return getBackgroundColor(errorContainer);
    }

    public String getTextOfErrorContainer() {
        return getText(errorContainer);
    }

    public boolean loginContainerIsDisplayed() {
        return isDisplayed(loginContainer);
    }
}
