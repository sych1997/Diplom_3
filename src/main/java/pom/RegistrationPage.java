package pom;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
    private WebDriver driver;
    //Ввод имени
    private By inputName = By.xpath(".//div/label[text()='Имя']/../input");
    //Ввод электронной почты
    private By inputEmail = By.xpath(".//div/label[text()='Email']/../input");
    //Ввод пароля
    private By inputPassword = By.xpath(".//div/label[text()='Пароль']/../input");
    //Кнопка регистрации
    private By buttonRegistration = By.xpath(".//button[text()='Зарегистрироваться']");
    //Кнопка Войти под формой регистрации
    private By buttonEnter = By.xpath(".//a[text()='Войти']");
    //Кнопка входа(появляется после успешной регистрации)
    private By buttonLogin = By.xpath(".//button[text()='Войти']");
    //Сообщение о некорректном пароле
    private By InvalidPassword = By.xpath(".//p[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    //Метод ввода имени
    public void enterName(String name) {
        driver.findElement(inputName).click();
        driver.findElement(inputName).sendKeys(name);
    }
    //Метод ввода электронной почты
    public void enterEmail(String email) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
    }
    //Метод ввода пароля
    public void enterPassword(String password) {
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
    }
    //Клик по кнопке регистрации
    public void clickButtonRegistration() {
        driver.findElement(buttonRegistration).click();
    }
    //Клик по кнопке Войти
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
    //Проверка успешной регистрации
    public void checkingSuccessfulRegistration() {
        Assert.assertTrue(driver.findElement(buttonLogin).isDisplayed());
    }
    //Проверка не успешной регистрации
    public void checkingUnsuccessfulRegistration() {
        Assert.assertTrue(driver.findElement(InvalidPassword).isDisplayed());
    }
}
