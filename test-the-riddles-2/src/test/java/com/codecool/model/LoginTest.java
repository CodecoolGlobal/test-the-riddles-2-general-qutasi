package com.codecool.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String LOGIN_URL = "http://localhost:3000/login";
    private static final String HOMEPAGE_URL = "http://localhost:3000/";
    
    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//span[contains(text(),'Sign up')]"))
            .click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test11", "test@test.com", "test11");
        loginPage.login("test11", "test11", HOMEPAGE_URL);
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testCanLogoutAfterSuccessfulLogin() {
        NavbarPage navbarPage = new NavbarPage(driver);
        navbarPage.logout();
        navbarPage.waitForPage(LOGIN_URL);
        assertTrue(navbarPage.isLoginBtnVisible(),  "User should be logged out and login button should be visible");
    }
}









