package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    private final By registrationLink = By.xpath(".//a[@class = 'Auth_link__1fOlj'][text() = 'Зарегистрироваться']");
    private final By emailInput = By.xpath("//div/label[text()='Email']/..//input");
    private final By passwordInput = By.xpath("//div/label[text()='Пароль']/..//input");
    private final By buttonLogin = By.xpath(".//button[contains(text(),'Войти')]");

    //конструктор класса с вызовом метода родительского класса
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickRegistrationLink() {
        driver.findElement(registrationLink).click();
    }

    @Step("Ввести креды пользователя и нажать кнопку войти ")
    public void loginUser(String email, String password) {
        setValue(emailInput, email);
        setValue(passwordInput, password);
        clickElement(buttonLogin);
    }

    @Step("Открыть страницу логина")
    public void openLoginPage() {
        driver.get(Constants.BASE_URL + "login");
    }

    @Step("Появление кнопки войти")
    public boolean buttonLoginIsVisible() {
        return checkElementVisibility(buttonLogin);
    }
}
