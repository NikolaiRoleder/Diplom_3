import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class Browser {
    WebDriver driver;

    public String getBrowser() throws IOException {
        // Выясняем в каком браузере необходимо запустить тесты. Берем данные о браузере из  properties
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream("src/main/resources/browser.properties"));
            return prop.getProperty("browser");
        } catch (FileNotFoundException e) {
            System.out.println("Ошибка! Файл не найден!");
            return null;
        }
    }

    public WebDriver getWebDriver() throws IOException {
        if (Objects.equals(getBrowser(), "chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (Objects.equals(getBrowser(), "yandex")) {
            System.setProperty("webdriver.chrome.driver", "src/main/resources/yandexdriver.exe");
            ChromeOptions options = new ChromeOptions();
            return new ChromeDriver(options);
        } else {
            System.out.println("Выбран некорректный браузер!");
            return null;
        }
    }

}