import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.ValidatableResponse;
import org.apache.http.HttpStatus;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class RegistrationTest extends BaseTest {

    @Test
    @DisplayName("Успешная регистрация пользователя")
    public void successRegistrationTest() {
        objMainPage.openMainPage();
        // Клик на кнопку Личный кабинет
        objMainPage.clickPersonalAccountButtonInHeader();
        // Клик на ссылку регистрация
        objLoginPage.clickRegistrationLink();
        // ввести креды пользователя в поля и нажать кнопку регистрация
        objRegisterPage.registrateUser(user.getName(), user.getEmail(), user.getPassword());
        // отправляем апи запрос на логин созданного пользователя, чтобы проверить возможность залогироваться
        userCredentials.setEmail(user.getEmail());
        userCredentials.setPassword(user.getPassword());
        ValidatableResponse loginResponse = userClient.loginUser(userCredentials);
        assertEquals(HttpStatus.SC_OK, loginResponse.extract().statusCode());
        // берем из ответа accessToken чтобы в дальнейшем можно было удалять юзеров
        String accessToken = loginResponse.extract().path("accessToken");
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Неуспешная регистрация пользователя с некорректным паролем меньше 6 символов")
    public void registrationWithIncorrectCredentialsTest() {
        objMainPage.openMainPage();
        // Клик на кнопку Личный кабинет
        objMainPage.clickPersonalAccountButtonInHeader();
        // Клик на ссылку регистрация
        objLoginPage.clickRegistrationLink();
        // ввести креды пользователя в поля и нажать кнопку регистрация
        objRegisterPage.registrateUser(user.getName(), user.getEmail(), "1234");
        // проверяем что появилась ошибка о не правильном пароле
        assertTrue(objRegisterPage.passwordErrorMessageIsVisible());
    }

}