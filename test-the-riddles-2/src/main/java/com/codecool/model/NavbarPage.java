package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class NavbarPage {

    WebDriver driver;
    WebDriverWait wait;

    private final By loginBtnBy = By.cssSelector(".text-gray-900 > span:nth-child(1)");
    private final By signUpBtnBy = By.cssSelector(".bg-gradient-to-tr > span:nth-child(1)");
    private final By logoutBtnBy = By.cssSelector("span.hidden:nth-child(1)");
    private final By mainPageBtnBy = By.cssSelector(".container > a:nth-child(1)");
    private final By gamesBtnBy = By.cssSelector("li.antialiased:nth-child(1)");
    private final By quizzesBtnBy = By.cssSelector("li.antialiased:nth-child(2)");
    private final By myQuizzesBtnBy = By.cssSelector("li.antialiased:nth-child(3)");
    private final By accountBtnBy = By.cssSelector("li.antialiased:nth-child(4)");

    public NavbarPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    private boolean isElementVisible(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isLoginBtnVisible() {
        return isElementVisible(loginBtnBy);
    }

    public boolean isLogoutBtnVisible() {
        return isElementVisible(logoutBtnBy);
    }

    public void login() {
        if (isLoginBtnVisible()) {
            driver.findElement(loginBtnBy).click();
        }
    }

    public void logout() {
        if (isLogoutBtnVisible()) {
            driver.findElement(logoutBtnBy).click();
        }
    }

    public void waitForElementToBeVisible(WebElement element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getUrl() {
        return driver.getCurrentUrl();
    }

    public void waitForPage(String url) {
        wait.until(ExpectedConditions.urlToBe(url));
    }
}
