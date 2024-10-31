package factory;


import enums.BrowserArgument;
import exeptions.BrowserNotFoundEx;
import factory.settings.SettingsChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFabrika implements IbrowserFabrika {
    private String typeBrowserFromProperty = System.getProperty("browser");

    public  WebDriver start(BrowserArgument argument) {
        switch (typeBrowserFromProperty) {
            case "chrome": {
                if (argument.equals(BrowserArgument.FULL_SCREEN)) {
                    return new ChromeDriver(new SettingsChromeDriver().setFullScreenMod());
                } else if (argument.equals(BrowserArgument.HEADLESS)) {
                    return new ChromeDriver(new SettingsChromeDriver().setHeadlessMod());
                } else if (argument.equals(BrowserArgument.KIOSK)) {
                    return new ChromeDriver(new SettingsChromeDriver().setKioskMod());
                } else if (argument.equals(BrowserArgument.DEFAULT)) {
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
