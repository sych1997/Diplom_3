package base;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class Constants {
    private WebDriver driver;
    //Страница регистрации
    private String registrationUrl = "https://stellarburgers.nomoreparties.site/register";
    // Домашняя страница
    private String homeUrl = "https://stellarburgers.nomoreparties.site";
    private String recoveryPasswordUrl = "https://stellarburgers.nomoreparties.site/forgot-password";

    public Constants(WebDriver driver) {
        this.driver = driver;
    }

    //Метод открытия страницы
    public void openPage(String url) {
        driver.get(url);
    }
    //Получение URL домашней страницы
    public String getHomeUrl() {
        return homeUrl;
    }
    //Получение URL страницы регистрации
    public String getRegistrationUrl() {
        return registrationUrl;
    }
    //Получение URL страницы восстановления пароля
    public String getRecoveryPasswordUrl() {
        return recoveryPasswordUrl;
    }
}
