package tests;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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
    public void dockerSeleniumHub() throws MalformedURLException {
        // DockerHub
//        Use below commands to run Grid:
//        $ docker run -d -p 4444:4444 --name selenium-hub selenium/hub:3.4.0
//        $ docker run -d --link selenium-hub:hub selenium/node-chrome:3.4.0
//        $ docker run -d --link selenium-hub:hub selenium/node-firefox:3.4.0

        DesiredCapabilities desiredCapabilities = DesiredCapabilities.chrome();
//        desiredCapabilities.setBrowserName("chrome");
//        desiredCapabilities.setPlatform(Platform.LINUX);
      //  System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
      //  ChromeOptions desiredCapabilities = new ChromeOptions();
      //  desiredCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
     //   WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/grid/console"), desiredCapabilities);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapabilities);
      //  WebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.4:4444/grid/register"), desiredCapabilities);
        driver.get("https://www.guru99.com");
        driver.quit();


    }

    @AfterTest
    public void quit() {
        wd.quit();
    }

    public void captureScreenshot()throws IOException {
        String extension = ".png";
            File scrFile = ((TakesScreenshot)wd).getScreenshotAs(OutputType.FILE);
            String timestamp = new SimpleDateFormat("yyyy_MM_dd__hh_mm_ss").format(new Date());
            FileUtils.copyFile(scrFile, new File("./src/screenshots/" +timestamp+extension));
        }


}