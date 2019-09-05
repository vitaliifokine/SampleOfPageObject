package tests;

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

    @Test()
    public void dockerSeleniumHub() throws IOException {
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

    @AfterTest
    public void quit() {
        wd.quit();
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());
    }

    public void captureScreenshot(WebDriver driver) throws IOException {
        String extension = ".png";
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String timestamp = RandomString.make(4);
        String date = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
        FileUtils.copyFile(scrFile, new File("./src/screenshots/" + date + timestamp + extension));
    }
}