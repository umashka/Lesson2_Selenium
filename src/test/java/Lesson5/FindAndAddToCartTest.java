package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.Assert.assertTrue;

@DisplayName("Тесты добавления в корзину товара")
public class FindAndAddToCartTest {

    @Test
    @ParameterizedTest
    @ValueSource(strings = "мягкие игрушки")
    public void FindAndAddTest(String productName) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.sima-land.ru");

        webDriver.manage().window().setSize(new Dimension(1500, 920));

        webDriver.findElement(By.xpath("//input[@type='search']")).sendKeys(productName);
        webDriver.findElement(By.xpath("//button[@type='submit']")).click();

        List<WebElement> products = webDriver.findElements(By.xpath("//div[contains(@class,'catalog__item')]"));
        System.out.println("products.size = " + products.size()); //Это тестовое, чтобы посмотреть, что список не пустой.
        products.get(1).findElement(By.xpath("//div[contains(@class,'catalog__item')]//button[text()='В корзину']")).click();
        webDriver.findElement(By.xpath("//a[@href='/cabinet/cart/']")).click();

        // Вот тут в DevTools хорошо отлавливается количество элементов в корзине (и глазами тоже видно, что они добавляются),
        // но Джава почему-то их не видит. И выводит 0 добавленых элементов.
        System.out.println("Actual cart size = " + webDriver.findElements(By.xpath("//div[contains(@class,'catalog__item')]")).size());
        System.out.println("Expected cart size = 1");

        //Thread.sleep(10000); // Это для тестирования "глазами" :)
        webDriver.quit();

    }
}
