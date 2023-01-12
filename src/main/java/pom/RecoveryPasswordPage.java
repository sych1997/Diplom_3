package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecoveryPasswordPage {
    private WebDriver driver;
    //Кнопка войти
    private By buttonEnter = By.xpath(".//a[text()='Войти']");

    public RecoveryPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    //Клик по кнопке Войти
    public void clickButtonEnter() {
        driver.findElement(buttonEnter).click();
    }
}
