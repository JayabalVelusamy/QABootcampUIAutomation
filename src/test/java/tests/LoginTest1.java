package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest1 extends BaseTest {

    @Test
    public void searchAndAddToCartTest() {

        assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Login");

        driver.findElement(By.id("email")).sendKeys("jaya@sample.com");
        driver.findElement(By.cssSelector("#password")).sendKeys("jaya@sample.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        assertTrue(driver.findElement(By.xpath("//span[text()=' Your Basket']"))
                .isDisplayed());
    }

}
