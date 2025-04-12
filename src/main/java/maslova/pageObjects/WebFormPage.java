package maslova.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class WebFormPage extends BasePage {
    private static final String WEB_FORM_URL = "web-form.html";

    //Locators
    WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));

    public WebFormPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    public String getUrl() {
        return WEB_FORM_URL;
    }

    public void submitForm() {
        actions.moveToElement(submitButton).perform();
        submitButton.click();
    }
}
