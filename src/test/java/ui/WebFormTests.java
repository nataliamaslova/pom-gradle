package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.*;

class WebFormTests extends BaseTest{
    @Test
    void openWebFormTest() {
        String webFormUrl = "web-form.html";
        driver.findElement(By.linkText("Web form")).click();
        String currentUrl = driver.getCurrentUrl();
        WebElement title = driver.findElement(By.className("display-6"));

        assertEquals(BASE_URL + webFormUrl, currentUrl);
        assertEquals("Web form", title.getText());
    }

    @Test
    void checkTextareaTest()  {
        driver.findElement(By.linkText("Web form")).click();

        WebElement textArea = driver.findElement(By.cssSelector("textarea.form-control"));
        String textInputData = "Test\nTest2";

        textArea.sendKeys(textInputData);

        assertEquals(textInputData, textArea.getDomProperty("value"), "Text should be from file");
    }

    @Test
    void disabledInputTest() {
        driver.findElement(By.linkText("Web form")).click();

        WebElement disabledElement = driver.findElement(By.name("my-disabled"));

        assertFalse(disabledElement.isEnabled(), "Field should be turned off");
        assertEquals(
                "Disabled input", disabledElement.getDomProperty("placeholder"), "Wrong placeholder");
        assertThrows(
                ElementNotInteractableException.class, () -> disabledElement.sendKeys("Test"));
    }
}
