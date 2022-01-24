package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class OpenAppStoreLink {
    public static void main(String[] args) throws InterruptedException {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-settings=imagesEnabled=false");

        //WebDriver webDriver = WebDriverManager.chromedriver().create();
        WebDriver webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.sima-land.ru");

        // Вот тут, вроде локатор находится Джавой, но не могу понять, грузится ли другая вкладка.
        webDriver.findElement(By.xpath("//img[@alt='Загрузите в App Store']")).click();


        Thread.sleep(20000);
        webDriver.quit();
    }
}
