package pages;

import enums.IdArgument;
import exeptions.PasswordFailedEx;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbsBasePage{

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage setUserName(String text){
        enterText(setLocator(IdArgument.USERNAME),text);
    return this;
    }
    public RegistrationPage setEmail(String text){
        enterText(setLocator(IdArgument.EMAIL),text);
        return this;
    }
    public RegistrationPage setPassword(String text){
        enterText(setLocator(IdArgument.PASSWORD),text);
        return this;
    }
    public RegistrationPage setConfirmPassword(String text){
        enterText(setLocator(IdArgument.CONFIRM_PASSWORD),text);
        return this;
    }
    public void checkPasswordWithConfirm(){
        System.out.println( setLocator(IdArgument.PASSWORD).getAttribute("value"));
        String password = setLocator(IdArgument.PASSWORD).getAttribute("value");
        String confirm = setLocator(IdArgument.CONFIRM_PASSWORD).getAttribute("value");
        if (password.equals(confirm))
            System.out.println("Пароли верны");
        else
            throw new PasswordFailedEx(password,confirm);
    }


}
