package pom;

import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.containsString;

public class HomePage {
    private WebDriver driver;
    //Кнопка личный кабинет
    private By buttonPersonalAccount = By.xpath(".//p[text()='Личный Кабинет']");
    //Кнопка войти в аккаунт
    private By buttonSignlAccount = By.xpath(".//button[text()='Войти в аккаунт']");
    //Кнопка оформить заказ
    private By buttonPlaceOrder = By.xpath(".//button[text()='Оформить заказ']");
    //Кнопка булки
    private By buttonBun = By.xpath(".//span[text()='Булки']/..");
    //Кнопка Соусы
    private By buttonSauce = By.xpath(".//span[text()='Соусы']/..");
    //Кнопка Начинки
    private By buttonFilling = By.xpath(".//span[text()='Начинки']/..");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    //Вход в личный кабинет
    public void signPersonalAccount() {
        driver.findElement(buttonPersonalAccount).click();
    }
    //Клик по кнопке войти в аккаунт
    public void clickButtonSignAccount() {
        driver.findElement(buttonSignlAccount).click();
    }
    //Проверка успешного входа в аккаунт (появилась кнопка оформить заказ)
    public void checkingAccountLogin() {
        Assert.assertTrue(driver.findElement(buttonPlaceOrder).isDisplayed());
    }
    //Проверка выхода (вместо кнопки оформить заказ кнопка войти в аккаунт)
    public void checkingExitingAccount() {
        Assert.assertTrue(driver.findElement(buttonSignlAccount).isDisplayed());
    }
    //Клик по разделу булки
    public void clickSectionBun() {
        driver.findElement(buttonBun).click();
    }
    //Клик по разделу соусы
    public void clickSectionSauce() {
        driver.findElement(buttonSauce).click();
    }//Клик по разделу начинки
    public void clickSectionFilling() {
        driver.findElement(buttonFilling).click();
    }
    //Проверка, что открыт раздел булки
    public void checkSectionBun() {
        String text = driver.findElement(buttonBun).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    //Проверка, что открыт раздел соусы
    public void checkSectionSauce() {
        String text = driver.findElement(buttonSauce).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
    //Проверка, что открыт раздел Начинки
    public void checkSectionFilling() {
        String text = driver.findElement(buttonFilling).getAttribute("class");
        MatcherAssert.assertThat(text, containsString("current"));
    }
}
