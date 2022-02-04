package Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver webDriver;

    public MainPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public LoginPage ClickEnterButton(){
        webDriver.get("https://www.sima-land.ru"); // Вот тут выдет NullPointerException

        webDriver.manage().window().setSize(new Dimension(1300, 720));

        webDriver.findElement(By.linkText("Войти")).click();

        return new LoginPage(webDriver);
    }

    public MainPage ClickExitButton(){
        Actions builder = new Actions(webDriver);
        WebElement element = webDriver.findElement(By.xpath("//span[text()='Профиль']"));
        builder.moveToElement(element).build().perform();

        webDriver.findElement(By.linkText("Выход")).click();

        return new MainPage(webDriver);
    }

    public void CheckEnterButtonIsVisible(){
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Войти")));
    }

    public MainPage CheckWPMessageIsVisible(){
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Неправильный email, телефон или пароль']")));
        return this;
    }
}
