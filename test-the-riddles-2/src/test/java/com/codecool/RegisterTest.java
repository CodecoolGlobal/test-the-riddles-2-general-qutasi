package com.codecool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
public class RegisterTest {

    public WebDriver driver;
    
    @BeforeEach
    public void setUp() {
        driver = new FirefoxDriver();
        driver.get("http://localhost:3000");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath("//span[contains(text(),'Sign up')]"))
            .click();
    }
    
    @AfterEach
    public void tearDown() {
        driver.quit();
    }
    
    @Test
    public void testUnsuccessfulRegisterWithEmojis() {
        driver.findElement(By.id("user-name")).sendKeys("💩");
        driver.findElement(By.id("email")).sendKeys("💩");
        driver.findElement(By.id("password")).sendKeys("💩");
        driver.findElement(By.xpath("//button[contains(text(),'SIGN UP')]"))
            .click();
        
        driver.findElement(By.id("user-name")).sendKeys("💩");
        driver.findElement(By.id("password")).sendKeys("💩");
        driver.findElement(By.xpath("//button[contains(text(),'LOGIN')]"))
            .click();
        assertEquals("http://localhost:3000/login", driver.getCurrentUrl(), "It should not be available");
    }
    
  
}