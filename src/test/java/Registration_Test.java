import enums.BrowserArgument;
import factory.BrowserFabrika;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.RegistrationPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class Registration_Test {


    private WebDriver driver;
    private Logger logger = LogManager.getLogger(Registration_Test.class);
    private RegistrationPage registrationPage;



    @BeforeAll
    public static void setup() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver() {
        logger.info("Открытие браузера в режиме " + BrowserArgument.DEFAULT);
        driver = new BrowserFabrika().start(BrowserArgument.DEFAULT);
        registrationPage = new RegistrationPage(driver);
    }

    @Test
    public void resultTest() throws InterruptedException {
        logger.info("Переход по ссылке");
        registrationPage.open();
        registrationPage.
                setUserName("ygu").
                setEmail("ug8g").
                setPassword("78g8").
                setConfirmPassword("78g8").
                setBirthdate("29.07.1995");
        registrationPage.checkPasswordWithConfirm();

        Thread.sleep(5000);


//        assertThat(input.getAttribute("value"))
//                .as("Текст должен быть - 'ОТУС'")
//                .isEqualTo("ОТУС");
    }

    @AfterEach
    public void downDriver() {
        logger.info("Закрытие браузера и сессии драйвера");
        if (driver != null) {
            driver.close();
            driver.quit();

        }
    }
}
