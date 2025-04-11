package ui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HomePageTests extends BaseTest {
    @Test
    void openHomePageTest() {
        driver.get(BASE_URL);
        driver.manage().window().maximize();
        String actualTitle = driver.getTitle();

        assertEquals("Hands-On Selenium WebDriver with Java", actualTitle);
    }

    @Test
    void openAllLinksTest() {
        int linksCount = 0;
        driver.get(BASE_URL);
        List<WebElement> chapters = driver.findElements(By.xpath("//h5[@class='card-title']")); //cssSelector("h5.card-title")
        for (WebElement chapter : chapters) {
            System.out.println(chapter.getText());
            List<WebElement> links = chapter.findElements(By.xpath("./../a"));
            linksCount += links.size();
            for (WebElement link : links) {
                System.out.println(link.getText());
                actions.moveToElement(link).click().perform();
                driver.navigate().back();
            }
        }
        assertEquals(6, chapters.size());
        assertEquals(27, linksCount);
    }

    @Test
    void classesTest() {
        List<WebElement> links = driver.findElements(By.cssSelector(".btn.btn-outline-primary.mb-2"));
        assertEquals(27, links.size());
    }
}
