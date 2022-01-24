package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

/**
 * Hello world!
 *
 */
public class FindAndAddToCart
{
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.sima-land.ru");

        webDriver.findElement(By.xpath("//input[@type=\"search\"]")).sendKeys("мягкие игрушки"); // Работает!!!
        webDriver.findElement(By.xpath("//button[@type=\"submit\"]")).click();  // Работает!!!


        // TODO: доделать добавку в корзину, когда разберусь с локаторами.

        Thread.sleep(10000);
        webDriver.quit();
    }
}
