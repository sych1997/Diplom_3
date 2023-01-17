package pom;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage {
    private final WebDriver driver;
    //Кнопка профиль
    private final By buttonProfile = By.xpath(".//a[text()='Профиль']");
    //Кнопка выхода из аккаунта
    private final By buttonExit = By.xpath(".//button[text()='Выход']");
    // Кнопка конструктор
    private final By buttonConstructor = By.xpath(".//p[text()='Конструктор']");
    // Логотип Stellar Burgers
    private final By buttonStellarBurgers = By.xpath(".//*[name()='svg' and @fill='none']");

    public PersonalAccountPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Проверка, что кнопка профиль отображается")
    public void checkingButtonProfile() {
        Assert.assertTrue(driver.findElement(buttonProfile).isDisplayed());
    }

    @Step("Клик по кнопке конструктора")
    public void clickButtonConstructor() {
        driver.findElement(buttonConstructor).click();
    }

    @Step("Клик по логотипу Stellar Burgers.")
    public void clickButtonStellarBurgers() {
        driver.findElement(buttonStellarBurgers).click();
    }

    @Step("Клик по кнопке выхода")
    public void clickButtonExit() {
        driver.findElement(buttonExit).click();
    }
}
