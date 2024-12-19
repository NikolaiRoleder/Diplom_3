package pages;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PasswordRecoveryPage extends BasePage {
    private final By loginLink = By.xpath(".//a[@class = 'Auth_link__1fOlj'][text() = 'Войти']");

    public PasswordRecoveryPage(WebDriver driver) {
        super(driver);
    }

    @Step("Клик по линке войти на странице восстановления пароля")
    public void clickLoginLinkOnPasswordRecoveryPage() {
        driver.findElement(loginLink).click();
    }

    @Step("Загрузить по URL страницу восстановление пароля")
    public void openPasswordRecoveryPage() {
        driver.get(Constants.BASE_URL + "forgot-password");
    }
}