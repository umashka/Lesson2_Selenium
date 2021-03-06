package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class LoginAndLogout {
    public static void main(String[] args) throws InterruptedException {
        // https://pop-music.ru/

        // 1. Способ
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("https://pop-music.ru/");
//        Thread.sleep(10000);
//        webDriver.quit();

        // 2. Способ
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
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
        webDriver.quit();
    }
}