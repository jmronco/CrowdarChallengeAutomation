package org.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class ScreenshotUtil {

    private static final String SCREENSHOT_DIR = "target/screenshots";

    private ScreenshotUtil() {}

    public static Path capture(WebDriver driver, String testName) {
        try {
            byte[] bytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            Path dir = Paths.get(SCREENSHOT_DIR);
            Files.createDirectories(dir);
            Path file = dir.resolve(testName + "_" + timestamp + ".png");
            Files.write(file, bytes);
            return file;
        } catch (IOException | RuntimeException e) {
            System.err.println("No se pudo guardar el screenshot: " + e.getMessage());
            return null;
        }
    }
}