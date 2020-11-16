package tests;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BaseTest extends DriverFactory {
    @BeforeTest
    public void setUp() {
    wd = DriverFactory.setBrowser("chrome");
    wd.manage().window().maximize();
    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("./src/screenshots/" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
//        }
//    }

    @Step("Make a screenshot")
    @Attachment
    public byte[] captureScreenshot(WebDriver driver) throws IOException {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
    }

    @AfterTest
    public void quit() {
        wd.quit();
    }

    @Step("Make a screenshot")
    @Attachment
    public byte[] captureScreenshot()throws IOException {
        return ((TakesScreenshot) wd).getScreenshotAs(OutputType.BYTES);
        }
}