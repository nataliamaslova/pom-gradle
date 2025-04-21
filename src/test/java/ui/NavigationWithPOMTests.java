package ui;

import io.qameta.allure.Feature;
import maslova.pageObjects.HomePage;
import maslova.pageObjects.NavigationPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static ui.BaseTest.BASE_URL;

@Feature("POM")
class NavigationWithPOMTests extends BaseTestForPOM {
    @Test
    void openNavFormTest() throws InterruptedException {
        HomePage homePage = new HomePage(driver, actions);
        NavigationPage navigationPage = homePage.openNavigationPage();
        String currentUrl = navigationPage.getCurrentUrl();
        String  title = navigationPage.getTitle();
        String webFormUrl = navigationPage.getUrl();

        navigationPage.clickNextButton();
        navigationPage.clickNextButton();
        Thread.sleep(3000);

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Navigation example", title);
    }

}
