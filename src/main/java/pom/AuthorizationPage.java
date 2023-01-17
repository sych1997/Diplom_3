package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AuthorizationPage {
    private final WebDriver driver;
    //Ввод электронной почты
    private final By inputEmail = By.xpath(".//div/label[text()='Email']/../input");
    //Ввод пароля
    private final By inputPassword = By.xpath(".//div/label[text()='Пароль']/../input");
    //Кнопка входа
    private final By buttonLogin = By.xpath(".//button[text()='Войти']");

    public AuthorizationPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Ввода электронной почты")
    public void enterEmail(String email) {
        driver.findElement(inputEmail).click();
        driver.findElement(inputEmail).sendKeys(email);
    }

    @Step("Ввод пароля")
    public void enterPassword(String password) {
        driver.findElement(inputPassword).click();
        driver.findElement(inputPassword).sendKeys(password);
    }

    @Step("Клик по кнопке \"Войти\"")
    public void clickButtonLogin() {
        driver.findElement(buttonLogin).click();
    }

    @Step("Ожидание кнопки \"Войти\"")
    public void expectationButtonLogin() {
        new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(ExpectedConditions.visibilityOfElementLocated(buttonLogin));
    }
}
