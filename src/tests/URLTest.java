package tests;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class URLTest extends BaseTest {

    @Test()
    public void testWiki() throws IOException {
        wd.manage().window().maximize();
        wd.get("https://www.guru99.com");
        captureScreenshot(wd);
    }

    @Test()
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
}