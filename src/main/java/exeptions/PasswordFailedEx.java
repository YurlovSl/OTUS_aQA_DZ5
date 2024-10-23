package exeptions;

public class PasswordFailedEx extends AssertionError{

    public PasswordFailedEx (String password, String confirmPassword){
        super(String.format("Пароль: %s не совпадает с паролем %s" ,password,confirmPassword));
    }
}
