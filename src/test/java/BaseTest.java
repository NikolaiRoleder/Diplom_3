import api.User;
import api.UserClient;
import api.UserCredentials;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import pageObject.*;

import java.io.IOException;

public abstract class BaseTest {
    WebDriver driver;
    MainPage objMainPage;
    LoginPage objLoginPage;
    RegisterPage objRegisterPage;
    PasswordRecoveryPage objPasswordRecoveryPage;
    PersonalAccountPage objPersonalAccountPage;
    UserClient userClient;
    UserCredentials userCredentials;
    User user;

    Browser browser = new Browser();

    @Before
    public void setUp() throws IOException {
        driver = browser.getWebDriver();
        // Создаем объекты классов страниц
        objMainPage = new MainPage(driver);
        objLoginPage = new LoginPage(driver);
        objRegisterPage = new RegisterPage(driver);
        objPasswordRecoveryPage = new PasswordRecoveryPage(driver);
        objPersonalAccountPage = new PersonalAccountPage(driver);
        userClient = new UserClient();
        userCredentials = new UserCredentials();
        user = new User("sobaca@yandex.ru", "123456", "Olivoa");

    }

    @After
    public void teardown() {
        // Закрыть браузер
        driver.quit();
    }
}