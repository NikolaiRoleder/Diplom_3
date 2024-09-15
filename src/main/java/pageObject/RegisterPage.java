package pageObject;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage extends BasePage {
    // локатор поля "Имя"
    private final By nameInput = By.xpath(".//div/label[text()='Имя']/..//input");
    // локатор поля "Email"
    private final By emailInput = By.xpath(".//div/label[text()='Email']/..//input");
    // локатор поля "Пароль"
    private final By passwordInput = By.xpath(".//div/label[text()='Пароль']/..//input");
    // Локатор кнопки "Зарегестрироваться"
    private final By registrationButton = By.xpath(".//button[contains(text(),'Зарегистрироваться')]");
    //Локатор сообщения об ошибке пароля
    private final By passwordErrorMessage = By.xpath(".//p[@class = 'input__error text_type_main-default']");
    // Локатор линка "Войти" на странице регистрации
    private final By loginLinkInRegistrationPage = By.xpath(".//a[@class = 'Auth_link__1fOlj'][text() = 'Войти']");

    //конструктор класса с вызовом метода родительского класса
    public RegisterPage(WebDriver driver) {
        super(driver);
    }

    public void registrateUser(String name, String email, String password) {
        setValue(nameInput, name);
        setValue(emailInput, email);
        setValue(passwordInput, password);
        clickElement(registrationButton);
    }

    @Step("Кликнуть по линке войти на странице регистрации")
    public void clickLinkLoginInRegistrationPage() {
        driver.findElement(loginLinkInRegistrationPage).click();
    }

    @Step("Появление ошибки о невалидном пароле")
    public boolean passwordErrorMessageIsVisible() {
        return checkElementVisibility(passwordErrorMessage);
    }

    @Step("Загрузить по URL страницу регистрации")
    public void openRegisterPage() {
        driver.get(Constants.BASE_URL + "register");
    }
}
