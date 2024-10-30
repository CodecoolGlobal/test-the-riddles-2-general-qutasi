package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class QuizzesPage extends NavbarPage{

    private final By firstPlayBtnBy = By.cssSelector("button.bg-green-400:nth-child(3)");
    private final By firstCopyBtnBy = By.cssSelector(".bg-yellow-400");
    private final By addQuizBtnBy = By.cssSelector(".w-32");
    public QuizzesPage(WebDriver driver) {
        super(driver);
    }
}
