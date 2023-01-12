import base.GenerateUsers;
import base.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.AuthorizationPage;
import pom.HomePage;
import pom.RecoveryPasswordPage;
import pom.RegistrationPage;

import java.time.Duration;

@DisplayName("Проверка авторизации")
public class AuthorizationTest {
    private WebDriver driver;
    Constants constants;
    RegistrationPage registration;
    AuthorizationPage authorizationPage;
    RecoveryPasswordPage recoveryPasswordPage;
    HomePage homePage;
    GenerateUsers users;
    private String email;
    private String Password;

    @Before
    public void beginning() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        registration = new RegistrationPage(driver);
        recoveryPasswordPage = new RecoveryPasswordPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        constants = new Constants(driver);
        users = new GenerateUsers();
        email = users.cretedEmail();
        Password = users.cretedValidPassword();
        constants.openPage(constants.getRegistrationUrl());
        registration.enterName(users.cretedFirstName());
        registration.enterEmail(email);
        registration.enterPassword(Password);
        registration.clickButtonRegistration();
    }
    @Test
    @DisplayName("Проверка входа через личный кабинет")
    public void checkLoginPersonalAccount() {
        constants.openPage(constants.getHomeUrl());
        homePage.signPersonalAccount();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(Password);
        authorizationPage.clickButtonLogin();
        homePage.checkingAccountLogin();
    }
    @Test
    @DisplayName("Проверка входа через главную страницу")
    public void checkLoginButtonHomePage() {
        constants.openPage(constants.getHomeUrl());
        homePage.clickButtonSignAccount();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(Password);
        authorizationPage.clickButtonLogin();
        homePage.checkingAccountLogin();
    }
    @Test
    @DisplayName("Проверка входа через форму регистрации")
    public void checkLoginRegistration() {
        constants.openPage(constants.getRegistrationUrl());
        registration.clickButtonEnter();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(Password);
        authorizationPage.clickButtonLogin();
        homePage.checkingAccountLogin();
    }
    @Test
    @DisplayName("Проверка входа через форму восстановления пароля")
    public void checkLoginRecoveryPassword() {
        constants.openPage(constants.getRecoveryPasswordUrl());
        recoveryPasswordPage.clickButtonEnter();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(Password);
        authorizationPage.clickButtonLogin();
        homePage.checkingAccountLogin();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
