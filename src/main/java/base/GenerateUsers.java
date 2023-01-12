package base;

import com.github.javafaker.Faker;

public class GenerateUsers {
    Faker faker = new Faker();

    //Создание рандомного имени
    public String cretedFirstName() {
        return faker.name().firstName();
    }
    //Создание рандомной почты
    public String cretedEmail() {
        return faker.internet().safeEmailAddress();
    }
    //Создание валидного пароля
    public String cretedValidPassword() {
        return faker.internet().password(6, 20);
    }
    //Создание не валидного пароля
    public String cretedNotValidPassword() {
        return faker.internet().password(1, 5);
    }
}
