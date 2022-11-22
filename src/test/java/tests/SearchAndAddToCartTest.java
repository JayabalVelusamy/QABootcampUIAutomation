package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SearchAndAddToCartTest extends BaseTest{

    @Test
    public void searchAndAddToCartTest() {

        driver.findElement(By.id("keywords")).sendKeys("Jersey");

        driver.findElement(By.xpath("//input[@value='Search']")).click();

        assertTrue(driver.findElement(By.xpath("//span[contains(text(),'Jersey')]"))
                .isDisplayed());

        String selectedProduct = driver.findElement(By.xpath("(//span[contains(text(),'Jersey')])[1]")).getText();

        driver.findElement(By.xpath("(//span[contains(text(),'Jersey')])[1]")).click();


        assertEquals(driver.findElement(By.cssSelector(".product-title")).getText(),
                selectedProduct);
        driver.findElement(By.cssSelector("#add-to-cart-button")).click();

        assertEquals(driver.findElement(By.xpath("//div[@data-hook='cart_container']/h1")).getText(), "Shopping Cart");
        assertEquals(driver.findElement(By.xpath("//h4/a")).getText(),
                selectedProduct);
        assertEquals(driver.findElement(By.xpath("//button[@name='checkout']")).getText(), "Checkout");


    }

}
