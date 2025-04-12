package ui;

import maslova.pageObjects.HomePage;
import maslova.pageObjects.WebFormPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;
import static ui.BaseTest.BASE_URL;

class WebFormWithPOMTests extends BaseTestForPOM {
    @Test
    void openWebFormTest() {
        HomePage homePage = new HomePage(driver, actions);
        WebFormPage webFormPage = homePage.openWebFormPage();
        String currentUrl = webFormPage.getCurrentUrl();
        WebElement title = webFormPage.getTitle();
        String webFormUrl = webFormPage.getUrl();

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());
    }

    @Test
    void submitFormTest() {
        HomePage homePage = new HomePage(driver, actions);
        WebFormPage webFormPage = homePage.openWebFormPage();

        webFormPage.submitForm();
    }

    @Test
    void checkTextareaTest()  {
        HomePage homePage = new HomePage(driver, actions);

        driver.findElement(By.linkText("Web form")).click();

        WebElement textArea = driver.findElement(By.cssSelector("textarea.form-control"));
        String textInputData = "Test\nTest2";

        textArea.sendKeys(textInputData);

        assertEquals(textInputData, textArea.getDomProperty("value"), "Text should be from file");
    }

    @Test
    void disabledInputTest() {
        HomePage homePage = new HomePage(driver, actions);

        driver.findElement(By.linkText("Web form")).click();

        WebElement disabledElement = driver.findElement(By.name("my-disabled"));

        assertFalse(disabledElement.isEnabled(), "Field should be turned off");
        assertEquals(
                "Disabled input", disabledElement.getDomProperty("placeholder"), "Wrong placeholder");
        assertThrows(
                ElementNotInteractableException.class, () -> disabledElement.sendKeys("Test"));
    }
}
