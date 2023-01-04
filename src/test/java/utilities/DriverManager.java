package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

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
        driver = WebDriverManager.chromedriver().create();
        return driver;
    }
}
