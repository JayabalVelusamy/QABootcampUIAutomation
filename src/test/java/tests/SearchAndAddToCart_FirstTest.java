package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchAndAddToCart_FirstTest {

    @Test
    public void searchAndAddToCartTest(){

        WebDriver driver = WebDriverManager.chromedriver().create();
        driver.get("https://juice-shop.herokuapp.com/#/");

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//button[@color='primary']")).click();
        driver.findElement(By.linkText("Me want it!")).click();

        driver.findElement(By.id("navbarAccount")).click();
        driver.findElement(By.id("navbarLoginButton")).click();

        assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Login");

        driver.findElement(By.id("email")).sendKeys("jaya@sample.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("jaya@sample.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(driver.findElement(By.xpath("//span[text()=' Your Basket']"))
                .isDisplayed());
        driver.findElement(By.xpath("//mat-icon[text()=' search ']")).click();
        driver.findElement(By.xpath("//input[contains(@id,'mat-input')]")).sendKeys("apple");

        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.ENTER).build().perform();

        assertTrue(driver.findElement(By.xpath("//div[contains(text(),'Apple')]"))
                .isDisplayed());

        driver.findElement(By.xpath("(//span[text()='Add to Basket'])[1]")).click();

        driver.findElement(By.xpath("//span[text()=' Your Basket']")).click();

        assertEquals(driver.findElement(By.xpath("//h1")).getText(),"Your Basket");

        driver.close();
        driver.quit();
    }

}
