package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class Helper {
    protected WebDriver driver;
    protected WebDriverWait webDriverWait;

    public Helper(WebDriver driver){
        this.driver = driver;
        this.webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    // в методах хроним общую логику над элементами

    public void enterText (WebElement element, String text){
        element.clear();
        element.click();
        element.sendKeys(text);
    }
}
