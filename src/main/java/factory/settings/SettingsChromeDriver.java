package factory.settings;

import enums.BrowserArgument;
import org.openqa.selenium.chrome.ChromeOptions;

public class SettingsChromeDriver {
    private ChromeOptions options = new ChromeOptions();

    public ChromeOptions setHeadlessMod(){
        return options.addArguments(BrowserArgument.HEADLESS.getArgumentBrowser());
    }
    public ChromeOptions setKioskMod(){
        return options.addArguments(BrowserArgument.KIOSK.getArgumentBrowser());
    }
    public ChromeOptions setDefaultMod(){
        return options.addArguments(String.valueOf(BrowserArgument.DEFAULT));
    }
    public ChromeOptions setFullScreenMod(){
        return options.addArguments(BrowserArgument.FULL_SCREEN.getArgumentBrowser());
    }

}
