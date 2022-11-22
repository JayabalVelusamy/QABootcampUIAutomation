package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.DriverManager;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    WebDriver driver;

    @BeforeMethod
    public void SetUp() {
        driver = DriverManager.getDriver();
        driver.get("http://spree-vapasi.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void TearDown() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
    }
}
