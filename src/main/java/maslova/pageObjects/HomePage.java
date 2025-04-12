package maslova.pageObjects;

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
    private void open() {
        driver.get(BASE_URL);
    }

    public String getWebTitle() {
        return driver.getTitle();
    }

    // method -> another Page Object
    public WebFormPage openWebFormPage() {
        driver.findElement(By.linkText("Web form")).click();
        return new WebFormPage(driver, actions);
    }

    public NavigationPage openNavigationPage() {
        driver.findElement(By.linkText("Navigation")).click();
        return new NavigationPage(driver, actions);
    }
}
