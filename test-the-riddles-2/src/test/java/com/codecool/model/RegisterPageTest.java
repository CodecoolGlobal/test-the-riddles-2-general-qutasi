package com.codecool.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterPageTest {
    
    private WebDriver driver;
    private WebDriverWait wait;
    private static final String LOGIN_URL = "http://localhost:3000/login";
    private static final String HOMEPAGE_URL = "http://localhost:3000/";
    private static final String SUCCESS_REGISTER_DATA_SOURCE = "/register_success.csv";
    private static final String FAIL_REGISTER_DATA_SOURCE = "/register_fail.csv";
    
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
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
    
    
    @ParameterizedTest
    @CsvFileSource(resources = SUCCESS_REGISTER_DATA_SOURCE, numLinesToSkip = 1)
    @DisplayName("test successful registration with correct credentials")
    public void successfulRegistration(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        wait.until(ExpectedConditions.urlToBe(HOMEPAGE_URL));
        assertEquals(HOMEPAGE_URL, homePage.getUrl());
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 1)
    @DisplayName("test unsuccessful registration")
    public void testUnSuccessfulRegistration(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    //bugreport: emoji is a valid character and user can login with it.
/*
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 1)
    @DisplayName("test unsuccessful registration with already existed username with new email and password")
    public void testUnsuccessfulRegistrationWithNewEmailAndPassword(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 1)
    @DisplayName("test unsuccessful registration with already existed email with new username and password")
    public void testUnsuccessfulRegistrationWithNewUsernameAndPassword(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        assertEquals(LOGIN_URL, homePage.getUrl(), "should not be a successful login");
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 1)
    @DisplayName("test unsuccessful registration without email")
    public void testUnsuccessfulRegistrationWithoutEmail(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username,email, password);
        HomePage homePage = loginPage.login(username, password);
        wait.until(ExpectedConditions.urlToBe(LOGIN_URL));
        assertEquals(LOGIN_URL, homePage.getUrl(), "Should not be a successful login");
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 2)
    @DisplayName("test unsuccessful registration with only numbers")
    public void testUnsuccessfulRegisterWithNumbers(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character");
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 4)
    @DisplayName("test unsuccessful registration with only whitespaces")
    public void testUnsuccessfulRegisterWithWhitespace(String username, String email, String password) {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp(username, email, password);
        HomePage homePage = loginPage.login(username, password);
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character");
    }
    
    @ParameterizedTest
    @CsvFileSource(resources = FAIL_REGISTER_DATA_SOURCE, numLinesToSkip = 3)
    @DisplayName("test unsuccessful registration with only special characters")
    public void testUnsuccessfulRegisterWithSpecialCharacter() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("¶","¶","¶");
        HomePage homePage = loginPage.login("¶", "¶");
        assertEquals(LOGIN_URL, homePage.getUrl(), "Need bug report. Not available character. Should not be a successful login");
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
*/
}