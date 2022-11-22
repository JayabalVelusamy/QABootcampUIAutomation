package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import utilities.DriverManager;

import static org.testng.Assert.assertTrue;

public class SearchFeatureTestsWithPOM extends BaseTest {
    WebDriver driver = DriverManager.getDriver();
    HomePage homePage = new HomePage(driver);

    @Test
    public void searchAndAddToCartTest() {
        homePage.enterValueToSearch("Jersey");
        homePage.clickOnSearchBtn();
        homePage.VerifySearchReturnedResults();
    }


}
