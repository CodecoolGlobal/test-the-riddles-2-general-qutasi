package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    public static final String URL = "http://localhost:3000/login";
    
    protected WebDriver driver;
    private By userNameBy = By.id("user-name");
    private By passwordBy = By.id("password");
    private By loginButtonBy = By.xpath("//button[contains(text(),'LOGIN')]");
    
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public HomePage login(String username, String password) {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(loginButtonBy).click();
        return new HomePage(driver);
    }
    
    
}
