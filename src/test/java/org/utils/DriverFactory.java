package org.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.util.HashMap;
import java.util.Map;


public final class DriverFactory {
    private DriverFactory() {}

    public static WebDriver createDriver() {
        String browser = System.getProperty("browser", "chrome").toLowerCase();
        return switch (browser) {
            case "chrome" -> new ChromeDriver(chromeOptions());
            case "edge" -> new EdgeDriver(edgeOptions());
            default -> throw new IllegalStateException(
                    "Browser no soportado: " + browser + ". Usa chrome o edge");
        };
    }

    private static ChromeOptions chromeOptions() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", passwordPrefs());
        options.addArguments("--incognito");
        options.addArguments("--disable-features=PasswordLeakDetection,SafeBrowsingEnhancedProtection");
        return options;
    }

    private static EdgeOptions edgeOptions() {
        EdgeOptions options = new EdgeOptions();
        options.setExperimentalOption("prefs", passwordPrefs());
        options.addArguments("--inprivate");
        options.addArguments("--disable-features=PasswordLeakDetection,SafeBrowsingEnhancedProtection");
        return options;
    }

    private static Map<String, Object> passwordPrefs() {
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        return prefs;
    }
}
