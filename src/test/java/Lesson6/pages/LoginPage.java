package Lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver webDriver;

    public LoginPage(WebDriver webDriver){
        this.webDriver = webDriver;
    }

    public MainPage login(String login, String password){
        By authFormLocator = By.xpath("//div[@class='os-padding']");
        new WebDriverWait(webDriver, 10).until(ExpectedConditions.presenceOfElementLocated(authFormLocator));

        webDriver.findElement(By.xpath("//label[text()='Email или телефон']//following-sibling::div//input")).sendKeys(login);
        webDriver.findElement(By.xpath("//label[text()='Пароль']//following-sibling::div//input")).sendKeys(password);
        webDriver.findElement(By.xpath("//button[.='Войти']")).click();
        return new MainPage(webDriver);
    }
}
