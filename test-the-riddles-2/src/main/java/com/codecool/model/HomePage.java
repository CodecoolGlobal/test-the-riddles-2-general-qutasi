package com.codecool.model;

import org.openqa.selenium.WebDriver;

public class HomePage extends NavbarPage{
    
    protected WebDriver driver;
    public static final String URL = "http://localhost:3000/";
    
    public HomePage(WebDriver driver) {
        super(driver);
    }
    
}
