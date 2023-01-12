import base.Constants;
import base.GenerateUsers;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.*;

import java.time.Duration;

@DisplayName("Проверка связанные с личным кабинетом")
public class PersonalAccountTest {
    private WebDriver driver;
    Constants constants;
    RegistrationPage registration;
    AuthorizationPage authorizationPage;
    HomePage homePage;
    PersonalAccountPage personalAccountPage;
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
        authorizationPage = new AuthorizationPage(driver);
        personalAccountPage = new PersonalAccountPage(driver);
        constants = new Constants(driver);
        users = new GenerateUsers();
        email = users.cretedEmail();
        Password = users.cretedValidPassword();
        constants.openPage(constants.getRegistrationUrl());
        registration.enterName(users.cretedFirstName());
        registration.enterEmail(email);
        registration.enterPassword(Password);
        registration.clickButtonRegistration();
        authorizationPage.expectationButtonLogin();
        authorizationPage.enterEmail(email);
        authorizationPage.enterPassword(Password);
        authorizationPage.clickButtonLogin();
    }
    @Test
    @DisplayName("Проверка перехода в личный кабинет")
    public void transitionPersonalAccount() {
        homePage.signPersonalAccount();
        personalAccountPage.checkingButtonProfile();
    }
    @Test
    @DisplayName("Проверка перехода в конструктор через кнопку конструктор")
    public void transitionConstructor() {
        homePage.signPersonalAccount();
        personalAccountPage.clickButtonConstructor();
        homePage.checkingAccountLogin();
    }
    @Test
    @DisplayName("Проверка перехода в конструктор через логотип")
    public void transitionStellarBurgers() {
        homePage.signPersonalAccount();
        personalAccountPage.clickButtonStellarBurgers();
        homePage.checkingAccountLogin();
    }
    @Test
    @DisplayName("Проверка выхода из аккаунта")
    public void exitingAccount() {
        homePage.signPersonalAccount();
        personalAccountPage.clickButtonExit();
        constants.openPage(constants.getHomeUrl());
        homePage.checkingExitingAccount();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
