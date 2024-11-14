package com.codecool.model;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyQuizzesPage extends NavbarPage{
    private By firstPlayBtnBy = By.xpath("//button[contains(text(),'Play')]");
    private By firstEditBtnBy = By.xpath("//button[contains(text(),'Edit')]");
    private By firstDeleteBtnBy = By.xpath("//*[contains(text(),'Delete')]");
    private By addQuizBtnBy = By.xpath("//button[contains(text(),'Add Quiz')]");

    public MyQuizzesPage(WebDriver driver) {
        super(driver);
    }

    public void deleteQuiz() {
        WebElement firstDeleteBtn = driver.findElement(firstDeleteBtnBy);
        firstDeleteBtn.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }
    
}
