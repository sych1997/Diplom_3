package pom;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private final WebDriver driver;
    //Ввод имени
    private final By inputName = By.xpath(".//div/label[text()='Имя']/../input");
    //Ввод электронной почты
    private final By inputEmail = By.xpath(".//div/label[text()='Email']/../input");
    //Ввод пароля
    private final By inputPassword = By.xpath(".//div/label[text()='Пароль']/../input");
    //Кнопка регистрации
    private final By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    //Кнопка Войти под формой регистрации
    private final By buttonEnter = By.xpath(".//a[text()='Войти']");
    //Кнопка входа(появляется после успешной регистрации)
    private final By buttonLogin = By.xpath(".//button[text()='Войти']");
    //Сообщение о некорректном пароле
    private final By InvalidPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввод имени")
    public void enterName(String name) {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
    }

    @Step("Ввод электронной почты")
    public void enterEmail(String email) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Клик по кнопке регистрации")
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }

    @Step("Проверка успешной регистрации")
    public void checkingSuccessfulRegistration() {
        Assert.assertTrue(driver.findElement(buttonLogin).isDisplayed());
    }

    @Step("Проверка не успешной регистрации")
    public void checkingUnsuccessfulRegistration() {
        Assert.assertTrue(driver.findElement(InvalidPassword).isDisplayed());
    }
}
