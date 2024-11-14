package com.codecool.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class QuizFormPageTest {

    private WebDriver driver;
    private static final String ALL_QUIZZES_URL = "http://localhost:3000/quiz/all";
    private static final String MY_QUIZZES_URL = "http://localhost:3000/quiz/my";
    private static final String PRIMARY_TEST_USERNAME = "tester";
    private static final String PRIMARY_TEST_EMAIL = "test@domain.com";
    private static final String PRIMARY_TEST_PASSWORD = "test";

    @BeforeAll
    public static void setUpBeforeAll() {
        WebDriver driverBeforeAll = new FirefoxDriver();
        driverBeforeAll.manage().window().maximize();
        driverBeforeAll.get(BaseUrls.SIGN_UP.getUrl());
        RegisterPage registerPage = new RegisterPage(driverBeforeAll);
        registerPage.waitForPage(BaseUrls.SIGN_UP.getUrl());
        registerPage.signUp(PRIMARY_TEST_USERNAME, PRIMARY_TEST_EMAIL, PRIMARY_TEST_PASSWORD);
        driverBeforeAll.quit();
    }

    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(BaseUrls.LOGIN.getUrl());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(PRIMARY_TEST_USERNAME, PRIMARY_TEST_PASSWORD,BaseUrls.HOMEPAGE.getUrl());
        driver.get(BaseUrls.ALL_QUIZZES.getUrl());
    }

    @AfterEach
    public void tearDown() {
        driver.get(BaseUrls.MY_QUIZZES.getUrl());
        MyQuizzesPage myQuizzes = new MyQuizzesPage(driver);
        myQuizzes.deleteQuiz();
        driver.quit();
    }

    @Test
    public void test() {
        HomePage homePage = new HomePage(driver);
        homePage.goToQuizzes();
        assertEquals(BaseUrls.ALL_QUIZZES.getUrl(), driver.getCurrentUrl());
    }
}