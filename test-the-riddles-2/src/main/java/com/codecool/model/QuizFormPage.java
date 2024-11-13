package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuizFormPage extends NavbarPage{

    private final By addQuestionBtnBy = By.xpath("//button[contains(text(),'Add Question')]");
    private final By quizTitleFieldBy = By.id("name");
    private final By saveQuizBtnBy = By.xpath("//button[contains(text(),'Save quiz')]");
    private final By deleteQuizBtnBy = By.xpath("//button[contains(text(),'Delete quiz')]");
    private final By questionFieldBy = By.id("-1question");
    private final By timerBy = By.id("-1time");
    private final By answer1By = By.xpath("//label[text()='1.']/following-sibling::input");
    private final By checkbox1By = By.xpath("//input[starts-with(@id,'checkbox-')]");
    private final By answer2By = By.xpath("//label[text()='2.']/following-sibling::input");
    //private final By checkbox2By = By.xpath("//input[starts-with(@id,'checkbox-')]");
    private final By addOptionBy = By.xpath("//button[contains(text(),'Add option')]");
    private final By saveQuestionBtnBy = By.xpath("//button[contains(text(),'Save')]");
    private final By deleteQuestionBtnBy = By.xpath("//button[contains(text(),'Delete')]");

    public QuizFormPage(WebDriver driver) {
        super(driver);
    }
    
    
    
}
