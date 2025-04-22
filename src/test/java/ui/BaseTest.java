package ui;

import maslova.configs.TestPropertiesConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

import static maslova.patterns.factory.WebDriverFactory.createWebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected Actions actions;
    protected static final String BASE_URL = "https://bonigarcia.dev/selenium-webdriver-java/";

    private TestPropertiesConfig configProperties = ConfigFactory.create(TestPropertiesConfig.class, System.getProperties());

    @BeforeEach
    void setup() {
        driver = createWebDriver(configProperties.browser());
        actions = new Actions(driver);
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }

}
