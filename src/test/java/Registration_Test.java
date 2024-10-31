import enums.BrowserArgument;
import enums.IdArgument;
import factory.BrowserFabrika;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import pages.RegistrationPage;

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
        registrationPage.setText(IdArgument.USERNAME, System.getProperty("userName"))
                        .setText(IdArgument.EMAIL, System.getProperty("email"))
                        .setText(IdArgument.PASSWORD, System.getProperty("password"))
                        .setText(IdArgument.CONFIRM_PASSWORD,System.getProperty("confPassword"))
                        .setBirthdate(System.getProperty("date"))
                        .checkPasswordWithConfirm();
        registrationPage.parseDate();
        registrationPage.setLevelLanguage(System.getProperty("levelL"));
        registrationPage.clickRegistration().checkOutputData();
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
