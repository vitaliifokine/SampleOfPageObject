package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DriverFactory;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BaseTest extends DriverFactory {
    @BeforeTest
    public void setUp() throws MalformedURLException {
        // Driver Factory Setup
//    wd = DriverFactory.setBrowser("chrome");
//    wd.manage().window().maximize();
//    wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @AfterMethod
//    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {
//        if (testResult.getStatus() == ITestResult.FAILURE) {
//            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
//            FileUtils.copyFile(scrFile, new File("./src/screenshots/" + testResult.getName() + "-"
//                    + Arrays.toString(testResult.getParameters()) +  ".jpg"));
//        }
//    }

    @Test()
    public void dockerSeleniumHub() throws IOException {
        try {
            executeGrid();
        } catch (SessionNotCreatedException sessionNotCreatedException){
            }
    }

    private void executeGrid() throws IOException {
       // Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Julia_Kolesnyk\\IdeaProjects\\SampleOfPageObject2\\chromedriver.exe");
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setBrowserName("chrome");
        cap.setVersion("");
        cap.setPlatform(Platform.WIN10);
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("--disable-extensions");
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.merge(cap);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.get("https://www.guru99.com");
        driver.quit();
        Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");
        System.out.println("V2");
    }
    @AfterTest
    public void quit() {

    }

    public void captureScreenshot()throws IOException {
        String extension = ".png";
            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            FileUtils.copyFile(scrFile, new File("./src/screenshots/" +timestamp+extension));
        }


}