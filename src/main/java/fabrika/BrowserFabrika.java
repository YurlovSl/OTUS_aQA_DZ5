package fabrika;


import enums.ArgumentBrowser;
import exeptions.BrowserNotFoundEx;
import fabrika.settings.SettingsChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFabrika implements IbrowserFabrika {
    private String typeBrowserFromProperty = System.getProperty("browser");

    public WebDriver start(ArgumentBrowser argument) {
        switch (typeBrowserFromProperty) {
            case "chrome": {
                if (argument.equals(ArgumentBrowser.FULL_SCREEN)) {
                    return new ChromeDriver(new SettingsChromeDriver().setFullScreenMod());
                } else if (argument.equals(ArgumentBrowser.HEADLESS)) {
                    return new ChromeDriver(new SettingsChromeDriver().setHeadlessMod());
                } else if (argument.equals(ArgumentBrowser.KIOSK)) {
                    return new ChromeDriver(new SettingsChromeDriver().setKioskMod());
                } else if (argument.equals(ArgumentBrowser.DEFAULT)) {
                    return new ChromeDriver(new SettingsChromeDriver().setDefaultMod());
                }
            }
            case "firefox": {
                return new FirefoxDriver();
            }
        }
        throw new BrowserNotFoundEx(typeBrowserFromProperty);
    }


}
