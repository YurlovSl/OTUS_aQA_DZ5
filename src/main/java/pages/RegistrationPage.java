package pages;

import enums.IdArgument;
import exeptions.DateFormEx;
import exeptions.PasswordFailedEx;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class RegistrationPage extends AbsBasePage {

    @FindBy(css = "[type='submit']")
    private WebElement btnSubmit;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setUserName(String text) {
        enterText(setLocator(IdArgument.USERNAME), text);
        return this;
    }

    public RegistrationPage setEmail(String text) {
        enterText(setLocator(IdArgument.EMAIL), text);
        return this;
    }

    public RegistrationPage setPassword(String text) {
        enterText(setLocator(IdArgument.PASSWORD), text);
        return this;
    }

    public RegistrationPage setConfirmPassword(String text) {
        enterText(setLocator(IdArgument.CONFIRM_PASSWORD), text);
        return this;
    }

    public RegistrationPage setBirthdate(String text) {
        enterText(setLocator(IdArgument.BIRTHDATE), text);
        if (text.matches("^\\d{2}.\\d{2}.\\d{4}$")) {
            logger.info("Прошла проверка на формат даты");
        } else throw new DateFormEx(text);
        return this;
    }

    public String parseDate (){
        String[] parts = System.getProperty("date").split("\\.");
        return String.format("%s-%s-%s", parts[2], parts[1], parts[0]);
    }


    public String setLevelLanguage(String level){
        String lvl = String.format("option[value='%s']",System.getProperty("levelL"));
        WebElement levelLanguage = driver.findElement(By.cssSelector(lvl));

        if (!levelLanguage.isSelected()){
            logger.info("Выбран элемент в выпадающем окне? - " + levelLanguage.isSelected());
            setLocator(IdArgument.LANGUAGE_LEVEL).click();
            levelLanguage.click();
            webDriverWait.until(ExpectedConditions.elementToBeSelected(levelLanguage));
            setLocator(IdArgument.LANGUAGE_LEVEL).click();
            logger.info("Выбран элемент в выпадающем окне? - " + levelLanguage.isSelected());
        } else
            logger.info("Элемент уже выбран");
        return levelLanguage.getAttribute("value");
    }


    public void checkPasswordWithConfirm() {
        String password = setLocator(IdArgument.PASSWORD).getAttribute("value");
        String confirm = setLocator(IdArgument.CONFIRM_PASSWORD).getAttribute("value");

        if (password.equals(confirm))
            logger.info("Пароли верны");
        else
            throw new PasswordFailedEx(password, confirm);
    }

    public void clickRegistration(){
        btnSubmit.click();
    }
    public void checkOutputData(){
        String acrtualOutput = setLocator(IdArgument.OUTPUT).getText();

        String expectedOutput = String.format("Имя пользователя: %s\nЭлектронная почта: %s\nДата рождения: %s\nУровень языка: %s",
                System.getProperty("userName"), System.getProperty("email"), parseDate(), setLevelLanguage(System.getProperty("levelL")) );
        logger.info(setLocator(IdArgument.OUTPUT).getText());
        logger.info(expectedOutput);
        assertThat(acrtualOutput).isEqualTo(expectedOutput);



    }
}
