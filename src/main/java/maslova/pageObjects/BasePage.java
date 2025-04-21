package maslova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    WebDriver driver;
    Actions actions;

    // Locators
    // локатор будет искаться заново по умолчанию: избавляемся от StaleElementReferenceException
    @FindBy(className = "display-6" )
    private WebElement title;
//    By title = By.className("display-6");

    public BasePage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
        PageFactory.initElements(driver, this);
    }

    @Step("Getting current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get subpage title")
    public String getTitle() {
        return title.getText();
    }
}
