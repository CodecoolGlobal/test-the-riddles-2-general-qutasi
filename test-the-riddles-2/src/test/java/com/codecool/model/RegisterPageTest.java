package com.codecool.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chromium.ChromiumNetworkConditions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterPageTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String LOGIN_URL = "http://localhost:3000/login";
    private static final String HOMEPAGE_URL = "http://localhost:3000/";
    private HomePage homePage;
    
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//span[contains(text(),'Sign up')]"))
            .click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        homePage = new HomePage(driver);
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testSuccessfulRegistrationWithCorrectCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "test@test.com", "test");
        HomePage homePage = loginPage.login("test", "test");
        //wait.until(ExpectedConditions.urlToBe("http://localhost:3000/")); //if it false throws error, not needed assertion.
        String currentUrl = homePage.driver.getCurrentUrl();
        assertEquals(HOMEPAGE_URL, currentUrl);
    }
    
    @Test
    public void testUnSuccessfulRegistrationWithAlreadyExistedUserNameAndPasswordButDifferentEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "second@email.com", "test");
        HomePage homePage = loginPage.login("test", "test");
        //wait.until(ExpectedConditions.urlToBe(HomePage.URL));
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedUserNameWithNewEmailAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "third@email.com", "test2");
        HomePage homePage = loginPage.login("test", "test2");
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedEmailWithNewUserNameAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test3", "third@email.com", "test3");
        HomePage homePage = loginPage.login("test3", "test3");
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegistrationWithoutEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signIn("test4", "test4");
        HomePage homePage = loginPage.login("test4", "test4");
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "Should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlyWhitespace() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(" "," ", " ");
        HomePage homePage = loginPage.login(" ", " ");
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "Need bug report. Not available character");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlySpecialCharacter() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("¶","¶","¶");
        HomePage homePage = loginPage.login("¶", "¶");
        assertEquals(LOGIN_URL, homePage.driver.getCurrentUrl(), "Need bug report. Not available character. Should not be a successful login");
    }
    
    @Test
    public void testUnsuccessfulRegisterWithOnlyEmoji() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("❌","❌", "❌");
        loginPage.login("❌", "❌");
        try {
            wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
        }
        catch (Exception e) {
            throw new RuntimeException("Need bug report. Not available character. Should not be a successful login");
        }
    }
    
}