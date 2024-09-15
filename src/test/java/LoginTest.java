import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private String accessToken;

    @Before
    public void registerUser() {
        // Создаем пользователя с помощью API
        // берем из ответа accessToken чтобы в дальнейшем можно было удалять пользователя
        accessToken = userClient.createUser(user).extract().path("accessToken");
    }

    @After
    public void deleteUser() {
        //удаляем тестового пользователя
        userClient.deleteUser(accessToken);
    }

    @Test
    @DisplayName("Успешный вход по кнопке «Войти в аккаунт» на главной")
    public void successLoginUserOnMainPage() {
        objMainPage.openMainPage();
        // Переходим по кнопке на страницу логина
        objMainPage.clickLoginPersonalAccountButton();
        //логинимся
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //Проверяем, что отображается кнопка "Оформить заказ" вместо "Войти в аккаунт"
        assertTrue(objMainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Успешный вход через кнопку «Личный кабинет»")
    public void successLoginUserOnLoginPage() {
        objMainPage.openMainPage();
        // Кликаем по кнопке личный кабинет
        objMainPage.clickPersonalAccountButtonInHeader();
        //логинимся
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //Проверяем, что отображается кнопка "Оформить заказ" вместо "Войти в аккаунт"
        assertTrue(objMainPage.orderButtonIsVisible());

    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме регистрации")
    public void successLoginUserOnRegisterPage() {
        // Открываем страницу регистрации по URL
        objRegisterPage.openRegisterPage();
        // Кликаем по ссылке "Войти" на странице регистрации.
        objRegisterPage.clickLinkLoginInRegistrationPage();
        //логинимся
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //Проверяем, что отображается кнопка "Оформить заказ" вместо "Войти в аккаунт"
        assertTrue(objMainPage.orderButtonIsVisible());
    }

    @Test
    @DisplayName("Успешный вход через кнопку в форме восстановления пароля")
    public void successLoginUserOnPasswordRecoveryPage() {
        // Открываем страницу восстановления пароля по URL
        objPasswordRecoveryPage.openPasswordRecoveryPage();
        // Кликаем по ссылке "Войти" на странице восстановления пароля.
        objPasswordRecoveryPage.clickLoginLinkOnPasswordRecoveryPage();
        //логинимся
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //Проверяем, что отображается кнопка "Оформить заказ" вместо "Войти в аккаунт"
        assertTrue(objMainPage.orderButtonIsVisible());
    }
}
