package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

/**
 * Hello world!
 *
 */
public class FindAndAddToCart
{
    public static void main( String[] args ) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.sima-land.ru");

        webDriver.manage().window().setSize(new Dimension(1500, 920));

        webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys("мягкие игрушки");
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[contains(@class,'catalog__item')]"));
        System.out.println("products.size = " + products.size()); //Это тестовое, чтобы посмотреть, что список не пустой.
        products.get(1).findElement(By.xpath("//div[contains(@class,'catalog__item')]//button[text()='В корзину']")).click();
        webDriver.findElement(By.xpath("//a[@href='/cabinet/cart/']")).click();

        // Вот тут в DevTools хорошо отлавливается количество элементов в корзине, но Джава почему-то их не видит. И выводит 0 добавленых элементов.
        System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//div[contains(@class,'catalog__item')]")).size());
        System.out.println("Expected cart size = 1");

        Thread.sleep(10000);
        webDriver.quit();
    }
}
