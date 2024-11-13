package com.codecool.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GamesPage extends NavbarPage{

    private final By firstJoinBy = By.xpath("//button[contains(text(),'Join')]");
    
    public GamesPage(WebDriver driver) {
        super(driver);
    }

}
