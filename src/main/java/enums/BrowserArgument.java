package enums;

public enum BrowserArgument {
    HEADLESS("--headless"),
    KIOSK("--kiosk"),
    FULL_SCREEN("--start-maximized"),
    DEFAULT(null);

    private String argumentBrowser;

    BrowserArgument(String argumentBrowser) {
        this.argumentBrowser = argumentBrowser;
    }

    public String getArgumentBrowser() {
        return argumentBrowser;
    }
}
