package com.codecool.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ScreenshotUtil {
    
    public static void takeScreenshot(WebDriver driver, String testName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
        Path screenshotsDir = Paths.get("screenshots");
        Path filePath = screenshotsDir.resolve(testName + "_" + timestamp + ".png");
        try {
            Files.createDirectories(screenshotsDir);
            Files.copy(screenshot.toPath(), filePath);
            System.out.println("Screenshot saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Screenshot could not be saved");
        }
    }
}
