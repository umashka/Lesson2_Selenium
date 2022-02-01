package Lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

@DisplayName("Открытие страницы AppStore в новой вкладке")
public class OpenAppStoreLinkTest {
    
    @Test
    public void openAppStoreTest()
    {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.sima-land.ru");

        //Вот тут пробую клинкуть и на ссылку, и на ее картинку.
        // Джава пишет, что не может кликнуть по этим элементам, потому что они не кликабельные.
        // И предлагает кликнуть по DIV, который выше. Но он ведет на обе ссылки: Apple, Google.
        webDriver.findElement(By.xpath("//a[@href='https://apps.apple.com/app/apple-store/id1057565689']")).click();

        List<String> windows = List.copyOf(webDriver.getWindowHandles());

        // Вот тут не видит метод assertThat. Видимо опять я накосячила с зависимостями.
        //assertThat(windows).hasSize(2);

        //Thread.sleep(20000);
        webDriver.quit();        
    }
}
