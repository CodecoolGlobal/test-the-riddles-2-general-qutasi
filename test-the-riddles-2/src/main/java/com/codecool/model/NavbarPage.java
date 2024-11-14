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

    private final By loginBtnBy = By.xpath("//*[contains(text(),'Login')]");
    private final By signUpBtnBy = By.xpath("//button[contains(text(),'Sign up')]");
    private final By logoutBtnBy = By.xpath("//*[contains(text(),'Logout')]");
    private final By mainPageBtnBy = By.xpath("//a[contains(text(),'Reptile Riddles')]");
    private final By gamesBtnBy = By.xpath("//*[contains(text(),'Games')]");
    private final By quizzesBtnBy = By.xpath("//*[contains(text(),'Quizzes')]");
    private final By myQuizzesBtnBy = By.xpath("//*[contains(text(),'My Quizzes')]");
    private final By accountBtnBy = By.xpath("//*[contains(text(),'Account')]");

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

    public void clickGames() {
        driver.findElement(gamesBtnBy).click();
    }
    
    public void clickQuizzes() {
        driver.findElement(quizzesBtnBy).click();
    }
    
    public void clickMyQuizzes() {
        driver.findElement(myQuizzesBtnBy).click();
    }

    public void clickAccount() {
        driver.findElement(accountBtnBy).click();
    }
}
