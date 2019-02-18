package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverFactory;

public class BasePage extends DriverFactory {
    public BasePage(WebDriver driver) {
        this.wd = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitUntilDisplayedBy(WebElement webelement){
        WebDriverWait wait = new WebDriverWait(wd, 10);
        wait.until(ExpectedConditions.visibilityOf(webelement));
    }
}
