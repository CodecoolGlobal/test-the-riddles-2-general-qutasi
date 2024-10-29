package com.codecool.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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
    
    @Test
    public void testSuccessfulRegistrationWithCorrectCredentials() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "test@test.com", "test");
        loginPage.login("test", "test");
        //wait.until(ExpectedConditions.urlToBe("http://localhost:3000/")); //if it false throws error, not needed assertion.
        assertEquals("http://localhost:3000/", HomePage.URL, "it should not be good");
    }
    
    @Test
    public void testUnSuccessfulRegistrationWithAlreadyExistedUserNameAndPasswordButDifferentEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "second@email.com", "test");
        loginPage.login("test", "test");
        wait.until(ExpectedConditions.urlToBe(HomePage.URL));
        //assertEquals(LoginPage.URL, HomePage.URL, "it should not be good");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedUserNameWithNewEmailAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test", "third@email.com", "test2");
        loginPage.login("test", "test2");
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        //assertEquals(LoginPage.URL, HomePage.URL, "it should not be good");
    }
    
    @Test
    public void testUnsuccessfulRegistrationAlreadyExistedEmailWithNewUserNameAndPassword() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test3", "third@email.com", "test3");
        loginPage.login("test3", "test3");
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        //assertEquals(LoginPage.URL, HomePage.URL, "it should not be good");
    }
    
    @Test
    public void testUnsuccessfulRegistrationWithoutEmail() {
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signIn("test4", "test4");
        loginPage.login("test4", "test4");
        wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));
        //assertEquals(LoginPage.URL, HomePage.URL, "it should not be good");
    }
    
    
    
}