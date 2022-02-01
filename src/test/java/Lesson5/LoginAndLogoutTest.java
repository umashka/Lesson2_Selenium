package Lesson5;

import static org.junit.Assert.assertTrue;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
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
public class LoginAndLogoutTest {

    public WebDriver webDriver;

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @Test
    @DisplayName("Авторизация: верный логин и пароль")
    public void successAuthTest()
    {

        webDriver.get("https://www.sima-land.ru");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Войти")).click();

        By authFormLocator = By.xpath("//div[@class='os-padding']");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));

        webDriver.findElement(By.xpath("//label[text()='Email или телефон']//following-sibling::div//input")).sendKeys("sigipid576@oglerau.com");
        webDriver.findElement(By.xpath("//label[text()='Пароль']//following-sibling::div//input")).sendKeys("Qwerty7890");
        webDriver.findElement(By.xpath("//button[.='Войти']")).click();

        Actions builder = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.xpath("//span[text()='Профиль']"));
        builder.moveToElement(element).build().perform();

        webDriver.findElement(By.linkText("Выход")).click();

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));
    }

    @Test
    @DisplayName("Авторизация: неверный пароль")
    public void failedAuthTestWrongPassword()
    {
        webDriver.get("https://www.sima-land.ru");

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Войти")).click();

        By authFormLocator = By.xpath("//div[@class='os-padding']");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));

        webDriver.findElement(By.xpath("//label[text()='Email или телефон']//following-sibling::div//input")).sendKeys("sigipid576@oglerau.com");
        webDriver.findElement(By.xpath("//label[text()='Пароль']//following-sibling::div//input")).sendKeys("1111111");
        webDriver.findElement(By.xpath("//button[.='Войти']")).click();
        //webDriver.findElement(By.xpath("//*[@id=\"auth-recaptcha\"]")); //Пытаюсь ловить капчу
        //webDriver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")).click(); // И кликнуть по ней
        // Но, почему-то, все сработало и без клика по капче - не знаю, почему :)

        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Неправильный email, телефон или пароль']")));

    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }

}
