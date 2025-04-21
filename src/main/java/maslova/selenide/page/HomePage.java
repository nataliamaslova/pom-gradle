package maslova.selenide.page;

import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;
import static maslova.pageObjects.HomePage.BASE_URL;

public class HomePage extends BasePage {
    @Step("Open homepage")
    public void open() {
        Selenide.open(BASE_URL, HomePage.class);
    }

    @Step("Open Web form page")
    public WebFormPage openWebFormPage() {
        $(By.linkText("Web form")).click();
        return page(WebFormPage.class);
    }
}
