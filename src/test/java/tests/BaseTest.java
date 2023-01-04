package tests;

import org.openqa.selenium.By;
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
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://juice-shop.herokuapp.com/#/");
        driver.findElement(By.xpath("//button[@color='primary']")).click();
        driver.findElement(By.linkText("Me want it!")).click();
        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.cssSelector("#navbarLoginButton")).click();

    }

    @AfterMethod
    public void TearDown() {
        DriverManager.getDriver().close();
        DriverManager.getDriver().quit();
    }
}
