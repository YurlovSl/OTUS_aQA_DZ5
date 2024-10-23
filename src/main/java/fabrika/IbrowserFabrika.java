package fabrika;


import enums.ArgumentBrowser;
import org.openqa.selenium.WebDriver;

public interface IbrowserFabrika {
    WebDriver start( ArgumentBrowser argumentBrowser);
}
