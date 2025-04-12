package maslova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class BasePage {
    WebDriver driver;
    Actions actions;

    // Locators
    By title = By.className("display-6");

    public BasePage(WebDriver driver, Actions actions) {
        this.driver = driver;
        this.actions = actions;
    }

    @Step("Getting current url")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Get subpage title")
    public WebElement getTitle() {
        return driver.findElement(title);
    }
}
