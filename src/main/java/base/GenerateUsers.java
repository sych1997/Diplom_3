package base;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;

public class GenerateUsers {
    Faker faker = new Faker();

    @Step("Создание рандомного имени")
    public String cretedFirstName() {
        return faker.name().firstName();
    }

    @Step("Создание рандомной почты")
    public String cretedEmail() {
        return faker.internet().safeEmailAddress();
    }

    @Step("Создание валидного пароля")
    public String cretedValidPassword() {
        return faker.internet().password(6, 20);
    }

    @Step("Создание не валидного пароля")
    public String cretedNotValidPassword() {
        return faker.internet().password(1, 5);
    }
}
