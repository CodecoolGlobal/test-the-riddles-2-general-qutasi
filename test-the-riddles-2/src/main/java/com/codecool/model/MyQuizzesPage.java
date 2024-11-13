package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyQuizzesPage extends NavbarPage{
    private By firstPlayBtnBy = By.xpath("//button[contains(text(),'Play')]");
    private By firstEditBtnBy = By.xpath("//button[contains(text(),'Edit')]");
    private By firstDeleteBtnBy = By.xpath("//button[contains(text(),'Delete')]");
    private By addQuizBtnBy = By.xpath("//button[contains(text(),'Add Quiz')]");

    public MyQuizzesPage(WebDriver driver) {
        super(driver);
    }
    
}
