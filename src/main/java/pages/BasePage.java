package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    //ожидание появления элемента
    public static void waitForVisibilityOfElement(WebDriver driver, By locator, int timeout) {
        new WebDriverWait(driver, Duration.ofSeconds(timeout))
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //метод заполнения поля значением
    public void setValue(By locator, String value) {
        driver.findElement(locator).sendKeys(value);
    }

    //метод клика на элемент страницы
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    public boolean checkElementVisibility(By locator) {
        waitForVisibilityOfElement(driver, locator, 5);
        return driver.findElement(locator).isDisplayed();
    }

    public String getValue(By locator) {
        return driver.findElement(locator).getAttribute("value");
    }
}
