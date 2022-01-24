package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
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
        webDriver.get("https://www.sima-land.ru");

        webDriver.manage().window().setSize(new Dimension(980, 670));

        webDriver.findElement(By.linkText("Войти")).click(); // Это работает!!!

        // Вот этот локатор не работает на окошке авторизации. Потому что поиск выдает больше чем 1 элемент. Прошу помощи с конкретизацией.
        //webDriver.findElement(By.xpath("//input[@class='_1DuUO _31aP-']")).sendKeys("sigipid576@oglerau.com");

        // А вот эти два локатора в DevTools дают ровно тот элемент, который нужен. И он один в поиске. Но программа завершается с ошибкой.
        //webDriver.findElement(By.xpath("//input[@type='password']")).sendKeys("Qwerty7890");
        //webDriver.findElement(By.xpath("//button[@class='_26Mtj _3vUYf _3aLNo _1RgZS _3jQpp']")).click();


        Thread.sleep(10000);
        webDriver.quit();
    }
}