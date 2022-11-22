package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchFeatureTests extends BaseTest {

    @Test
    public void searchAndAddToCartTest() {

        driver.findElement(By.id("keywords")).sendKeys("Jersey");

        driver.findElement(By.xpath("//input[@value='Search']")).click();

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Jersey')]"))
                .isDisplayed());


    }


}
