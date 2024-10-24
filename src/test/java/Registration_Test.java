import enums.BrowserArgument;
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
        registrationPage.
                setUserName(System.getProperty("userName")).
                setEmail(System.getProperty("email")).
                setPassword(System.getProperty("password")).
                setConfirmPassword(System.getProperty("confPassword")).
                setBirthdate(System.getProperty("date"));
        registrationPage.checkPasswordWithConfirm();
        registrationPage.setLevelLanguage(System.getProperty("levelL"));
        registrationPage.clickRegistration();
        registrationPage.checkOutputData();


        Thread.sleep(5000);
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
