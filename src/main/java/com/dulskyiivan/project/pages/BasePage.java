package com.dulskyiivan.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected final WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }

    protected void type(By locator, String text) {
        WebElement element = find(locator);
        element.clear();
        element.sendKeys(text);
    }

    protected void click(By locator) {
        find(locator).click();
    }

    protected String getBackgroundColor(By locator) {
        return find(locator).getCssValue("background-color");
    }

    protected void setTimeout(int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    protected boolean isDisplayed(By locator) {
        return find(locator).isDisplayed();
    }

    protected String getText(By locator) {
        return find(locator).getText();
    }


}
