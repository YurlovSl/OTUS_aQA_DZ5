package fabrika.settings;

import enums.ArgumentBrowser;
import org.openqa.selenium.chrome.ChromeOptions;

public class SettingsChromeDriver {
    private ChromeOptions options = new ChromeOptions();

    public ChromeOptions setHeadlessMod(){
        return options.addArguments(ArgumentBrowser.HEADLESS.getArgumentBrowser());
    }
    public ChromeOptions setKioskMod(){
        return options.addArguments(ArgumentBrowser.KIOSK.getArgumentBrowser());
    }
    public ChromeOptions setDefaultMod(){
        return options.addArguments(String.valueOf(ArgumentBrowser.DEFAULT));
    }
    public ChromeOptions setFullScreenMod(){
        return options.addArguments(ArgumentBrowser.FULL_SCREEN.getArgumentBrowser());
    }

}
