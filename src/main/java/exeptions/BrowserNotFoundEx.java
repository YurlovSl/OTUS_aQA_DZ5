package exeptions;

public class BrowserNotFoundEx extends RuntimeException{
    public BrowserNotFoundEx (String browserName){
        super(String.format("Not found browser %s", browserName));
    }

}
