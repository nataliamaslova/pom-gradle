package maslova.pageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class NavigationPage extends BasePage {
    private static final String NAV_FORM_URL = "navigation1.html";


    public NavigationPage(WebDriver driver, Actions actions) {
        super(driver, actions);
    }

    @Step("Get subpage url")
    public String getUrl() {
        return NAV_FORM_URL;
    }
}
