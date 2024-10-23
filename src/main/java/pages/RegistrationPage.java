package pages;

import enums.IdArgument;
import exeptions.DateFormEx;
import exeptions.PasswordFailedEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistrationPage extends AbsBasePage {

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


    public void checkPasswordWithConfirm() {
        String password = setLocator(IdArgument.PASSWORD).getAttribute("value");
        String confirm = setLocator(IdArgument.CONFIRM_PASSWORD).getAttribute("value");

        if (password.equals(confirm))
            logger.info("Пароли верны");
        else
            throw new PasswordFailedEx(password, confirm);
    }


}
