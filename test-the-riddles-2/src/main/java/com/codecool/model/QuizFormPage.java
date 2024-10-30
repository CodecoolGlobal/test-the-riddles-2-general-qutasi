package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuizFormPage extends NavbarPage{

    private final By addQuestionBtnBy = By.cssSelector("button.h-fit");
    private final By quizTitleFieldBy = By.cssSelector("#name");
    private final By saveQuizBtnBy = By.cssSelector(".mr-4");
    private final By deleteQuizBtnBy = By.cssSelector("button.mt-2:nth-child(4)");
    private final By questionFieldBy = By.cssSelector("#-\\31 question");
    private final By timerBy = By.cssSelector("#-\\31 time");
    private final By answer1By = By.cssSelector("#answer-1");
    private final By checkbox1By = By.cssSelector("#checkbox-1");
    private final By answer2By = By.cssSelector("#answer-2");
    private final By checkbox2By = By.cssSelector("#checkbox-2");
    private final By addOptionBy = By.cssSelector("button.mt-2:nth-child(1)");
    private final By saveQuestionBtnBy = By.cssSelector("button.m-4:nth-child(1)");
    private final By deleteQuestionBtnBy = By.cssSelector("button.m-4:nth-child(2)");

    public QuizFormPage(WebDriver driver) {
        super(driver);
    }
}
