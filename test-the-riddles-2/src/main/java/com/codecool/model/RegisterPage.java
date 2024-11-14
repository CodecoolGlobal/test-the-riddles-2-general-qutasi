package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends NavbarPage{
    private static final String LOGIN_URL = "http://localhost:3000/login";
    private By userNameBy = By.id("user-name");
    private By emailBy = By.id("email");
    private By passwordBy = By.id("password");
    private By signUpBy = By.xpath("//button[contains(text(),'SIGN UP')]");
    
    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    
    public LoginPage signUp(String username, String email , String password) {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(emailBy).sendKeys(email);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signUpBy).click();
        waitForPage(LOGIN_URL);
        return new LoginPage(driver);
    }
    
    public LoginPage signIn(String username, String password) {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(signUpBy).click();
        waitForPage(LOGIN_URL);
        return new LoginPage(driver);
    }
}
