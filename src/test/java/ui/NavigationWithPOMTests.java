package ui;

import io.qameta.allure.Feature;
import maslova.pageObjects.HomePage;
import maslova.pageObjects.NavigationPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.BaseTest.BASE_URL;

@Feature("POM")
class NavigationWithPOMTests extends BaseTestForPOM {
    @Test
    void openNavFormTest() {
        HomePage homePage = new HomePage(driver, actions);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        WebElement title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title.getText());
    }

}
