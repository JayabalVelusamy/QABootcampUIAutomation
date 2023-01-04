package tests;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import utilities.DriverManager;

public class LoginWithPOM extends BaseTest{
    WebDriver driver= DriverManager.getDriver();
    LoginPage loginPage=new LoginPage(driver);

    @Test
    public void Login() {
        loginPage.enterEmail("jaya@sample.com");
        loginPage.enterPassword("jaya@sample.com");
        loginPage.clickOnLgin();

    }

}
