package com.codecool.model;

import com.codecool.utils.ScreenshotUtil;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPageTest {
    
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
        WebDriverWait waitBA = new WebDriverWait(driver, Duration.ofSeconds(5));
        RegisterPage registerPage = new RegisterPage(driver);
        LoginPage loginPage = registerPage.signUp("test11", "test@test.com", "test11");
        loginPage.login("test11", "test11");
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    @DisplayName("successful logout after login")
    public void testLogoutAfterLogin() {
        HomePage homePage = new HomePage(driver);
        homePage.logout();
        assertTrue(homePage.isLoginBtnVisible(),  "User should be logged out and login button should be visible");
    }
    
    @Test
    @DisplayName("keep login after click on Games page")
    public void testKeepLoginOnGames() {
        HomePage homePage = new HomePage(driver);
        homePage.clickGames();
        assertTrue(homePage.isLogoutBtnVisible());
    }
    
    @Test
    @DisplayName("keep login after click on Quizzes page")
    public void testKeepLoginOnQuizzes() {
        HomePage homePage = new HomePage(driver);
        homePage.clickQuizzes();
        assertTrue(homePage.isLogoutBtnVisible());
    }
    
    @Test
    @DisplayName("keep login after click on My Quizzes page")
    public void testKeepLoginOnMyQuizzes() {
        HomePage homePage = new HomePage(driver);
        homePage.clickMyQuizzes();
        assertTrue(homePage.isLogoutBtnVisible());
    }
    
    @Test
    @DisplayName("keep login after click on My Quizzes page")
    public void testKeepLoginOnAccount() {
        HomePage homePage = new HomePage(driver);
        homePage.clickAccount();
        homePage.highlightElement(driver);
        ScreenshotUtil.takeScreenshot(driver, "account-bug");
        assertTrue(homePage.isLogoutBtnVisible());
    }
}
