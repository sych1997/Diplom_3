package pom;

import io.qameta.allure.Step;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;

public class HomePage {
    private final WebDriver driver;
    //Кнопка личный кабинет
    private final By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка войти в аккаунт
    private final By buttonSignlAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка оформить заказ
    private final By buttonPlaceOrder = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка булки
    private final By buttonBun = By.xpath(".//span[text()='Булки']/..");
    //Кнопка Соусы
    private final By buttonSauce = By.xpath(".//span[text()='Соусы']/..");
    //Кнопка Начинки
    private final By buttonFilling = By.xpath(".//span[text()='Начинки']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Вход в личный кабинет")
    public void signPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }

    @Step("Клик по кнопке войти в аккаунт")
    public void clickButtonSignAccount() {
        driver.findElement(buttonSignlAccount).click();
    }

    @Step("Проверка успешного входа в аккаунт (появилась кнопка оформить заказ)")
    public void checkingAccountLogin() {
        Assert.assertTrue(driver.findElement(buttonPlaceOrder).isDisplayed());
    }

    @Step("Проверка выхода (вместо кнопки оформить заказ кнопка войти в аккаунт)")
    public void checkingExitingAccount() {
        Assert.assertTrue(driver.findElement(buttonSignlAccount).isDisplayed());
    }

    @Step("Клик по разделу булки")
    public void clickSectionBun() {
        driver.findElement(buttonBun).click();
    }

    @Step("Клик по разделу соусы")
    public void clickSectionSauce() {
        driver.findElement(buttonSauce).click();
    }

    @Step("Клик по разделу начинки")
    public void clickSectionFilling() {
        driver.findElement(buttonFilling).click();
    }

    @Step("Проверка, что открыт раздел булки")
    public void checkSectionBun() {
        String text = driver.findElement(buttonBun).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }

    @Step("Проверка, что открыт раздел соусы")
    public void checkSectionSauce() {
        String text = driver.findElement(buttonSauce).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }

    @Step("Проверка, что открыт раздел Начинки")
    public void checkSectionFilling() {
        String text = driver.findElement(buttonFilling).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
}
