import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class ConstructorTest extends BaseTest {

    @Test
    @DisplayName("Проверка перехода к разделу Булки")
    public void checkIsBunsTabSelected() {
        //открываем главную старницу
        objMainPage.openMainPage();
        // выбираем таб не булки
        objMainPage.clickSauceTab();
        // выбираем таб Булки
        objMainPage.clickBunsTab();
        //проверяем, что таб Булки выбран
        assertTrue(objMainPage.bunsTabSelected());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void checkIsSauceTabSelected() {
        //открываем главную старницу
        objMainPage.openMainPage();
        // выбираем таб не булки
        objMainPage.clickSauceTab();
        //проверяем, что таб Булки выбран
        assertTrue(objMainPage.sauceTabSelected());
    }

    @Test
    @DisplayName("Проверка перехода к разделу Соусы")
    public void checkIsFillingsTabSelected() {
        //открываем главную старницу
        objMainPage.openMainPage();
        // выбираем таб не булки
        objMainPage.clickFillingsTab();
        //проверяем, что таб Булки выбран
        assertTrue(objMainPage.fillingsTabSelected());
    }
}
