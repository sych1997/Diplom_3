package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private WebDriver driver;
    //Ввод электронной почты
    private By inputEmail = By.xpath(".//div/label[text()='Email']/../input");
    //Ввод пароля
    private By inputPassword = By.xpath(".//div/label[text()='Пароль']/../input");
    //Кнопка входа
    private By buttonLogin = By.xpath(".//button[text()='Войти']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
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
    //Клик по кнопке вход
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }
    //Ожидание кнопки войти
    public void expectationButtonLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
    }
}
