import base.Constants;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pom.HomePage;

import java.time.Duration;

@DisplayName("Проверка переходов по разделам")
public class ConstructorTest {
    private WebDriver driver;
    HomePage homePage;
    Constants constants;

    @Before
    public void beginning() {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe"); // для яндекса
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe"); // для хрома
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(7));
        driver.manage().window().maximize();
        homePage = new HomePage(driver);
        constants = new Constants(driver);
        constants.openPage(constants.getHomeUrl());
    }
    @Test
    @DisplayName("Проверка перехода в раздел булки")
    public void transitionBuns() {
        homePage.clickSectionSauce();
        homePage.clickSectionBun();
        homePage.checkSectionBun();
    }
    @Test
    @DisplayName("Проверка перехода в раздел соусы")
    public void transitionSauce() {
        homePage.clickSectionSauce();
        homePage.checkSectionSauce();
    }
    @Test
    @DisplayName("Проверка перехода в раздел начинки")
    public void transitionFilling() {
        homePage.clickSectionFilling();
        homePage.checkSectionFilling();
    }
    @After
    public void closeBrowser() {
        driver.quit();
    }
}
