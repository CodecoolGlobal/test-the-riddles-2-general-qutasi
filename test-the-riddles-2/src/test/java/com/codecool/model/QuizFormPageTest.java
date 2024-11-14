package com.codecool.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuizFormPageTest {

    private WebDriver driver;
    private static final String PRIMARY_TEST_USERNAME = "tester";
    private static final String PRIMARY_TEST_EMAIL = "test@domain.com";
    private static final String PRIMARY_TEST_PASSWORD = "test";
    private static final String PROPER_QUIZ_DATA = "/proper_quiz_data.csv";

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
        loginPage.login(PRIMARY_TEST_USERNAME, PRIMARY_TEST_PASSWORD);
        driver.get(BaseUrls.MY_QUIZZES.getUrl());
        MyQuizzesPage myQuizzesPage = new MyQuizzesPage(driver);
        myQuizzesPage.startQuizCreation();
    }

    @AfterEach
    public void tearDown() {
        driver.get(BaseUrls.MY_QUIZZES.getUrl());
        MyQuizzesPage myQuizzes = new MyQuizzesPage(driver);
        myQuizzes.deleteQuiz();
        driver.quit();
    }

    @ParameterizedTest
    @CsvFileSource(resources = PROPER_QUIZ_DATA, numLinesToSkip = 1)
    @DisplayName("test quiz creation with proper credentials")
    public void testProperlyCreatedQuiz(String quizTitle,String questionTitle,String answer1,String answer2) {
        QuizFormPage quizFormPage = new QuizFormPage(driver);
        quizFormPage.createQuiz(quizTitle,questionTitle,answer1,answer2);
        QuizzesPage quizzesPage = new QuizzesPage(driver);
        assertTrue(quizzesPage.isCopyVisible());
    }
}