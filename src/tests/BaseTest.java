package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.*;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends DriverFactory {
    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Driver Factory Setup
        wd = DriverFactory.setBrowser("remote");
        wd.manage().window().maximize();
    }

    @Feature("Docker")
    @Test()
    public void dockerSeleniumHub() throws IOException {
        wd.manage().window().maximize();
        wd.get("https://www.guru99.com");
        captureScreenshot(wd);
    }

    @Feature("Docker")
    @Test(description = "Docker test")
    public void dockerSeleniumHub6() throws IOException {
        wd.manage().window().maximize();
        wd.get("https://en.wikipedia.org/wiki/Wiki");
        captureScreenshot(wd);
    }

    @Test()
    public void dockerSeleniumHub9() throws IOException {
        wd.manage().window().maximize();
        wd.get("https://cucumber.io/docs/guides/10-minute-tutorial/");
        captureScreenshot(wd);
    }


    @Test()
    public void dockerSeleniumHub5() throws IOException {
        wd.manage().window().maximize();
        wd.get("https://www.un.org/en/");
        captureScreenshot(wd);
    }

    @AfterTest
    public void quit() {
        wd.quit();
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());
    }

    @Step("Make a screenshot")
    @Attachment
    public byte[] captureScreenshot(WebDriver driver) throws IOException {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }

    @Step("Save attachment")
    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot() {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }
    
}