package Lesson6.tests;

import Lesson6.pages.LoginPage;
import Lesson6.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

@DisplayName("Тесты авторизации")
public class LoginAndLogoutTest extends BaseTest {
    @Test
    @DisplayName("Авторизация: верный логин и пароль")
    public void successAuthTest()
    {

        webDriver.get(url); // Вот тут выдет NullPointerException

        new MainPage(webDriver).ClickEnterButton()
                .login(login,password)
                .ClickExitButton()
                .CheckEnterButtonIsVisible();
    }

    @Test
    @DisplayName("Авторизация: неверный пароль")
    public void failedAuthTestWrongPassword()
    {
        webDriver.get(url); // Вот тут выдет NullPointerException

        new MainPage(webDriver).ClickEnterButton();
        new LoginPage(webDriver).login(login,password);
        new MainPage(webDriver).ClickExitButton();
        new MainPage(webDriver).CheckWPMessageIsVisible();
    }
}
