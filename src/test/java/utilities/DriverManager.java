package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
    private static DriverManager driverManager;
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getDriver() {
        if (driverManager == null) {
            driverManager = new DriverManager();
            return driverManager.createWebDriver();
        }
        return driver;
    }

    private WebDriver createWebDriver() {
        driver = new ChromeDriver();
        return driver;
    }
}
