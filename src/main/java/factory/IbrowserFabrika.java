package factory;


import enums.BrowserArgument;
import org.openqa.selenium.WebDriver;

public interface IbrowserFabrika {
    WebDriver start( BrowserArgument browserArgument);
}
