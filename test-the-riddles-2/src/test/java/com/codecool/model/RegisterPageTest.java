package com.codecool.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPageTest {
    
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
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testSuccessfulRegistrationWithCorrectCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("testing", "test@test.com", "testing", LOGIN_URL);
        HomePage homePage = loginPage.login("testing", "testing");
        wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL)); //if it false throws error, not needed assertion.
        assertEquals(HOMEPAGE_URL, homePage.getUrl());
    }
    
    @Test
    public void testUnSuccessfulRegistrationWithAlreadyExistedUserNameAndPasswordButDifferentEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("username", "second@email.com", "password", LOGIN_URL);
        HomePage homePage = loginPage.login("username", "password");
        wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedUserNameWithNewEmailAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "third@email.com", "test2", LOGIN_URL);
        HomePage homePage = loginPage.login("test", "test2");
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedEmailWithNewUserNameAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test3", "third@email.com", "test3", LOGIN_URL);
        HomePage homePage = loginPage.login("test3", "test3");
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationWithoutEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signIn("test4", "test4");
        HomePage homePage = loginPage.login("test4", "test4");
        assertEquals(LOGIN_URL, homePage.getUrl(), "Should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlyNumbers() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("111","333@333.com", "333", LOGIN_URL);
        HomePage homePage = loginPage.login("111", "333");
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlyWhitespace() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(" "," ", " ", LOGIN_URL);
        HomePage homePage = loginPage.login(" ", " ");
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlySpecialCharacter() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("¶","¶","¶", LOGIN_URL);
        HomePage homePage = loginPage.login("¶", "¶");
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character. Should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlyEmoji() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("❌","❌", "❌", LOGIN_URL);
        loginPage.login("❌", "❌");
        try {
            wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
        }
        catch (Exception e) {
            throw new RuntimeException("Need bug report. Not available character. Should not be a successful login");
        }
    }
    
}