import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonalAccountTest extends BaseTest {

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
    @DisplayName("Успешный переход в личный кабинет по клику на «Личный кабинет»")
    public void successTransferToPersonalAccount() {
        //открываем страницу логина и логинимся
        objLoginPage.openLoginPage();
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //после того как залогинились, перекидывает на главную старницу где нужно нажать кнопку "Личный кабинет"
        objMainPage.clickPersonalAccountButtonInHeader();
        String actualName = objPersonalAccountPage.getNameValue();
        String actualEmail = objPersonalAccountPage.getEmailValue();
        assertEquals(user.getName(), actualName);
        assertEquals(user.getEmail(), actualEmail);
    }

    @Test
    @DisplayName("переход в конструктор по клику на «Конструктор»  из личного кабинета")
    public void successTransferToConstructorByConstructorLink() {
        //открываем страницу логина и логинимся
        objLoginPage.openLoginPage();
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //после того как залогинились, перекидывает на главную старницу где нужно нажать кнопку "Личный кабинет"
        objMainPage.clickPersonalAccountButtonInHeader();
        // кликаем на линку "Конструктор"
        objPersonalAccountPage.clickConstructorLink();
        assertTrue(objMainPage.constructorSectionIsVisible());
    }

    @Test
    @DisplayName("переход в конструктор по клику на Лого из личного кабинета")
    public void successTransferToConstructorByLogoLink() {
        //открываем страницу логина и логинимся
        objLoginPage.openLoginPage();
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //после того как залогинились, перекидывает на главную старницу где нужно нажать кнопку "Личный кабинет"
        objMainPage.clickPersonalAccountButtonInHeader();
        // кликаем на лого
        objPersonalAccountPage.clickLogoStelarBurger();
        assertTrue(objMainPage.constructorSectionIsVisible());
    }

    @Test
    @DisplayName("Выход по кнопке «Выйти» в личном кабинете.")
    public void successLogout() {
        //открываем страницу логина и логинимся
        objLoginPage.openLoginPage();
        objLoginPage.loginUser(user.getEmail(), user.getPassword());
        //после того как залогинились, перекидывает на главную старницу где нужно нажать кнопку "Личный кабинет"
        objMainPage.clickPersonalAccountButtonInHeader();
        //нажимаем кнопку Выход
        objPersonalAccountPage.clickLogoutButton();
        assertTrue(objLoginPage.buttonLoginIsVisible());
    }
}
