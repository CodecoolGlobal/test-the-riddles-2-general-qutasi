package com.codecool.model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class QuizFormPage extends NavbarPage{

    private final By addQuestionBtnBy = By.xpath("//button[contains(text(),'Add Question')]");
    private final By quizTitleFieldBy = By.id("name");
    private final By saveQuizBtnBy = By.xpath("//*[contains(text(),'Save quiz')]");
    private final By deleteQuizBtnBy = By.xpath("//button[contains(text(),'Delete quiz')]");
    private final By questionFieldBy = By.id("-1question");
    private final By timerBy = By.id("-1time");
    private final By answer1By = By.xpath("//*[text()='1. ']/following-sibling::input");
    private final By checkbox1By = By.xpath("//input[starts-with(@id,'checkbox-')]");
    private final By answer2By = By.xpath("//*[text()='2. ']/following-sibling::input");
    //private final By checkbox2By = By.xpath("//input[starts-with(@id,'checkbox-')]");
    private final By addOptionBy = By.xpath("//button[contains(text(),'Add option')]");
    private final By saveQuestionBtnBy = By.xpath("//button[contains(text(),'Save')]");
    private final By deleteQuestionBtnBy = By.xpath("//button[contains(text(),'Delete')]");

    public QuizFormPage(WebDriver driver) {
        super(driver);
    }

    public void createQuiz(String quizTitle, String questionTitle, String answer1, String answer2){
        driver.findElement(quizTitleFieldBy).sendKeys(quizTitle);
        addNewQuestion(questionTitle, answer1, answer2);
        driver.findElement(saveQuizBtnBy).click();
        //driver.switchTo().alert().accept();
    }

    private void fillField(By field, String string) {
        driver.findElement(field).sendKeys(string);
    }

    private void addNewQuestion(String questionTitle, String answer1, String answer2){
        driver.findElement(addQuestionBtnBy).click();
        fillField(questionFieldBy, questionTitle);
        fillField(answer1By, answer1);
        fillField(answer2By, answer2);
        driver.findElement(checkbox1By).click();
        driver.findElement(saveQuestionBtnBy).click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
}
