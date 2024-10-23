package enums;

public enum ArgumentBrowser {
    HEADLESS("--headless"),
    KIOSK("--kiosk"),
    FULL_SCREEN("--start-maximized"),
    DEFAULT(null);

    private String argumentBrowser;

    ArgumentBrowser(String argumentBrowser) {
        this.argumentBrowser = argumentBrowser;
    }

    public String getArgumentBrowser() {
        return argumentBrowser;
    }
}
