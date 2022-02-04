package Lesson6.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver webDriver;

    public String login = "sigipid576@oglerau.com";
    public String password = "Qwerty7890";
    public static String url = "https://www.sima-land.ru";

    @BeforeEach
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
    }

    @AfterEach
    public void tearDown(){
        webDriver.quit();
    }
}
