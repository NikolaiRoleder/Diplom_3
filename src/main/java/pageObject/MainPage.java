package pageObject;

import constants.Constants;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends BasePage {
    // локатор ссылки "Личный кабинет"
    private final By personalAccountLink = By.xpath("//p[text() = 'Личный Кабинет']");
    private final By loginPersonalAccountButton = By.xpath("//button[text()='Войти в аккаунт']");
    private final By orderButton = By.xpath("//button[text()='Оформить заказ']");
    private final By constructorSection = By.xpath("//section[@class='BurgerIngredients_ingredients__1N8v2']");
    private final By bunsTab = By.xpath("//div[span[text()='Булки']]");
    private final By sauceTab = By.xpath("//div[span[text()='Соусы']]");
    private final By fillingsTab = By.xpath("//div[span[text()='Начинки']]");

    //конструктор класса с вызовом метода родительского класса
    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Step("Нажать линку личный кабинет")
    public void clickPersonalAccountButtonInHeader() {
        driver.findElement(personalAccountLink).click();
    }

    @Step("Нажать кнопку войти в аккаунт")
    public void clickLoginPersonalAccountButton() {
        driver.findElement(loginPersonalAccountButton).click();
    }

    @Step("Появление кнопки оформить заказ")
    public boolean orderButtonIsVisible() {
        return checkElementVisibility(orderButton);
    }

    @Step("Загрузить по URL главную страницу")
    public void openMainPage() {
        driver.get(Constants.BASE_URL);
    }

    @Step("Появление конструктора заказа")
    public boolean constructorSectionIsVisible() {
        return checkElementVisibility(constructorSection);
    }

    @Step("Нажать таб Булки")
    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    @Step("Нажать таб Соус")
    public void clickSauceTab() {
        driver.findElement(sauceTab).click();
    }

    @Step("Нажать таб Начинки")
    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    @Step("Поиск таба Булки")
    public boolean bunsTabSelected() {
        return driver.findElement(bunsTab).getAttribute("class").contains("current");
    }

    @Step("Поиск таба Соус")
    public boolean sauceTabSelected() {
        return driver.findElement(sauceTab).getAttribute("class").contains("current");
    }

    @Step("Поиск таба Начинки")
    public boolean fillingsTabSelected() {
        return driver.findElement(fillingsTab).getAttribute("class").contains("current");
    }
}
