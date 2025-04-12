package ui;

import maslova.pageObjects.HomePage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageWithPOMTests extends BaseTestForPOM {

    @Test
    void openHomePageTest() {
        HomePage homePage = new HomePage(driver, actions);

        String actualTitle = homePage.getWebTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

}
