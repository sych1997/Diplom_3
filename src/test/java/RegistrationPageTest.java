import base.GenerateUsers;
import base.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.RegistrationPage;

import java.time.Duration;

@DisplayName("Проверка входа")
public class RegistrationPageTest {
    private WebDriver driver;
    Constants constants;
    RegistrationPage registration;
    GenerateUsers users;
    private String name;
    private String email;

    @Before
    public void beginning() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        registration = new RegistrationPage(driver);
        users = new GenerateUsers();
        constants = new Constants(driver);
        name = users.cretedFirstName();
        email = users.cretedEmail();
        constants.openPage(constants.getRegistrationUrl());
    }
    @Test
    @DisplayName("Проверка регистрации с валидным паролем")
    public void checkingRegistrationWithValidPassword() {
        registration.enterName(name);
        registration.enterEmail(email);
        registration.enterPassword(users.cretedValidPassword());
        registration.clickButtonRegistration();
        registration.checkingSuccessfulRegistration();
    }
    @Test
    @DisplayName("Проверка регистрации с не валидным паролем")
    public void checkingRegistrationWithNotValidPassword() {
        registration.enterName(name);
        registration.enterEmail(email);
        registration.enterPassword(users.cretedNotValidPassword());
        registration.clickButtonRegistration();
        registration.checkingUnsuccessfulRegistration();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
