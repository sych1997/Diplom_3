package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private final WebDriver driver;
    //Кнопка войти
    private final By buttonEnter = By.xpath(".//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Клик по кнопке Войти")
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
}
