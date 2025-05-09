package ui.fluent;

import io.qameta.allure.Feature;
import maslova.fluentPages.FluentLoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.BaseTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Fluent")
public class FluentLoginPageTests extends BaseTest {
    FluentLoginPage loginPage;

    @BeforeEach
    void initPages() {
        loginPage = new FluentLoginPage(driver);
    }

    @Test
    void testLoginSuccess() {
        loginPage
                .login("user", "user")
                .checkSuccessBoxPresent()
                .checkInvalidCredentialsBoxIsNotPresent();
    }

    @Test
    void testLoginFailure() {
        loginPage
                .login("test", "test")
                .checkInvalidCredentialsBoxPresent()
                .checkSuccessBoxIsNotPresent();
    }

    @Test
    void HeaderTest() {
        String headerText = loginPage
                .login("test", "test")
                .getHeader().getSubTitleText();

        assertEquals("Practice site", headerText);
    }
}
