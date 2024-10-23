package pages;

import enums.IdArgument;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.Helper;


public abstract class AbsBasePage extends Helper {
    public AbsBasePage(WebDriver driver) {
        super(driver);
    }

    private String baseUrl = System.getProperty("baseUrl");
    private String baseLocator = "#%s";

    public WebElement setLocator(IdArgument idArgument) {
        return driver.findElement(By.cssSelector(String.format(this.baseLocator, idArgument.getId())));
    }
}

