package maslova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static maslova.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    //Locators
    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitButton;

    public WebFormPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    @Step("Get subpage url")
    public String getUrl() {
        return WEB_FORM_URL;
    }

    @Step("Submit form")
    public void submitForm() {
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }

    @Step("Check that page is web form")
    public void checkIsWebPage() {
        assertEquals(BASE_URL + getUrl(), getCurrentUrl());
        assertEquals("Web form", getTitle());
    }
}
