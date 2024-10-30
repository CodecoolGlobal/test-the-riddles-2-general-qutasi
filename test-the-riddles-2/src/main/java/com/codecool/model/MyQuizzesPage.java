package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyQuizzesPage extends NavbarPage{
    private By firstPlayBtnBy = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button[3]");
    private By firstEditBtnBy = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button[2]");
    private By firstDeleteBtnBy = By.xpath("/html/body/div/div/div[2]/div/div[1]/div[1]/button[1]");
    private By addQuizBtnBy = By.xpath("/html/body/div/div/div[2]/div/div[1]/button");

    public MyQuizzesPage(WebDriver driver) {
        super(driver);
    }

    
}
