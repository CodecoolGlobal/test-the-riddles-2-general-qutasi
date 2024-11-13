package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuizzesPage extends NavbarPage{

    private final By firstPlayBtnBy = By.xpath("//button[contains(text(),'Play')]");
    private final By firstCopyBtnBy = By.xpath("//button[contains(text(),'Copy')]");
    private final By addQuizBtnBy = By.xpath("//button[contains(text(),'Add Quiz')]");
    public QuizzesPage(WebDriver driver) {
        super(driver);
    }
}
