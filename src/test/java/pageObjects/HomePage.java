package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "keywords")
    WebElement searchBox;

    @FindBy(xpath = "//input[@value='Search']")
    WebElement searchBtn;

    @FindBy(xpath = "//span[contains(text(),'Jersey')]")
    WebElement searchResult;

    public void enterValueToSearch(String searchValue) {
        searchBox.sendKeys(searchValue);
    }

    public void clickOnSearchBtn() {
        searchBtn.click();
    }

    public void VerifySearchReturnedResults() {
        searchResult.isDisplayed();
    }
}
