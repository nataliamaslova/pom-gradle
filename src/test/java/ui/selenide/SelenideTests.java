package ui.selenide;

import maslova.selenide.page.HomePage;
import maslova.selenide.page.WebFormPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.value;
import static maslova.pageObjects.HomePage.BASE_URL;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SelenideTests {
    HomePage homePage;

    @BeforeEach
    void setup() {
        homePage = new HomePage();
    }

    @Test
    void openHomePageTest() {
        homePage.open();

        assertEquals(BASE_URL, homePage.getCurrentUrl());
    }

    @Test
    void openWebFormPageTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        assertEquals(BASE_URL + webFormPage.getWebFormExpectedUrl(), webFormPage.getCurrentUrl());
        assertEquals("Hands-On Selenium WebDriver with Java", webFormPage.getWebTitle());
    }

    @Test
    void readonlyTextTest() {
        homePage.open();
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.getReadonlyInput().shouldHave(value("Readonly input"));
    }
}
