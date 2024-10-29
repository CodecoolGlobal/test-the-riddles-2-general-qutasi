package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
    
    protected WebDriver driver;
    private By userNameBy = By.id("user-name");
    private By emailBy = By.id("email");
    private By passwordBy = By.id("password");
    private By signUpBy = By.xpath("//button[contains(text(),'SIGN UP')]");
    
    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
    
    public LoginPage signUp(String username, String email , String password) {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signUpBy).click();
        return new LoginPage(driver);
    }
    
    public LoginPage signIn(String username, String password) {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signUpBy).click();
        return new LoginPage(driver);
    }
}
