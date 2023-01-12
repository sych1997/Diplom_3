package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PersonalAccountPage {
    private WebDriver driver;
    //Кнопка профиль
    private By buttonProfile = By.xpath(".//a[text()='Профиль']");
    //Кнопка выхода из аккаунта
    private By buttonExit = By.xpath(".//button[text()='Выход']");
    // Кнопка конструктор
    private By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    // Логотип Stellar Burgers
    private By buttonStellarBurgers = By.xpath(".//*[name()='svg' and @fill='none']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    //Проверка, что кнопка профиль отображается
    public void checkingButtonProfile() {
        Assert.assertTrue(driver.findElement(buttonProfile).isDisplayed());
    }
    //Клик по кнопке конструктора
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }
    //Клик по кнопке логотипа бургера
    public void clickButtonStellarBurgers() {
        driver.findElement(buttonStellarBurgers).click();
    }
    //Клик по кнопке выхода
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
}
