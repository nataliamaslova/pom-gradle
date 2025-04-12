package ui;

import io.qameta.allure.Feature;
import maslova.pageObjects.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("POM")
class HomePageWithPOMTests extends BaseTestForPOM {

    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver, actions);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

}
