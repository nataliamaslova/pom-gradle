package maslova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends BasePage {
    public static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";


    public HomePage(WebDriver driver, Actions actions) {
        super(driver, actions);
        open();
    }

    // locators

    // actions
    @Step("Open HomePage")
    private void open() {
        driver.get(BASE_URL);
    }

    @Step("Get web title")
    public String getWebTitle() {
        return driver.getTitle();
    }

    // method -> another Page Object
    @Step("Open WebFormPage")
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver, actions);
    }

    @Step("Open NavigationPage")
    public NavigationPage openNavigationPage() {
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver, actions);
    }
}
