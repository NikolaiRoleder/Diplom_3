package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonalAccountPage extends BasePage {
    // локатор поля "Имя"
    private final By nameInput = By.xpath(".//div/label[text()='Имя']/..//input");
    // локатор поля "Email"
    private final By emailInput = By.xpath(".//div/label[text()='Логин']/..//input");
    //кнопка Выход
    private final By logoutButton = By.xpath("//button[text()='Выход']");
    // Линк Конструктор
    private final By constructorLink = By.xpath("//p[@class = 'AppHeader_header__linkText__3q_va ml-2'][text() = 'Конструктор']");
    // Лого Stellar Burger
    private final By logoStellarBurger = By.xpath("//div[@class = 'AppHeader_header__logo__2D0X2']");

    public PersonalAccountPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить имя пользователя")
    public String getNameValue() {
        waitForVisibilityOfElement(driver, nameInput, 5);
        return getValue(nameInput);
    }

    @Step("Получить Email пользователя")
    public String getEmailValue() {
        waitForVisibilityOfElement(driver, emailInput, 5);
        return getValue(emailInput);
    }

    @Step("Кликнуть по кнопке выйти")
    public void clickLogoutButton() {
        waitForVisibilityOfElement(driver, logoutButton, 5);
        driver.findElement(logoutButton).click();
    }

    @Step("Кликнуть по линке конструктор")
    public void clickConstructorLink() {
        waitForVisibilityOfElement(driver, constructorLink, 5);
        driver.findElement(constructorLink).click();
    }

    @Step("Кликнуть по лого StelarBurger")
    public void clickLogoStelarBurger() {
        waitForVisibilityOfElement(driver, logoStellarBurger, 5);
        driver.findElement(logoStellarBurger).click();
    }
}
