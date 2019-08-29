package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class ParallelTest extends BaseTest {


    @Test()
    public void dockerSeleniumHub() throws MalformedURLException {
        // DockerHub
//        Use below commands to run Grid:
//        $ docker run -d -p 4444:4444 --name selenium-hub selenium/hub:3.4.0
//        $ docker run -d --link selenium-hub:hub selenium/node-chrome:3.4.0
//        $ docker run -d --link selenium-hub:hub selenium/node-firefox:3.4.0
        //System.setProperty("webdriver.chrome.driver", "chromedriver");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.LINUX);
        desiredCapabilities.setBrowserName("chrome");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars");
        chromeOptions.merge(desiredCapabilities);
        chromeOptions.addArguments("--allow-file-access-from-files"); /*Allow Chrome to access files*/
     //   chromeOptions.addArguments("user-data-dir="+System.getProperty("webdriver.chrome.driver")+"drivers/chromedriver.exe");
        desiredCapabilities.setBrowserName("chrome");
        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, desiredCapabilities);
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://www.guru99.com");
        driver.quit();


    }


    // Only for API - not Selenium
//        @BeforeMethod
//        public void beforeMethod() {
//        long id = Thread.currentThread().getId();
//        System.out.println("Before test-method. Thread id is: " + id);
//    }
//
//        @Test
//        public void testMethodsOne() {
//        long id = Thread.currentThread().getId();
//        System.out.println("Simple test-method One. Thread id is: " + id);
//    }
//
//        @Test(testName = "sample")
//        public void testMethodsTwo() {
//        long id = Thread.currentThread().getId();
//        System.out.println("Simple test-method Two. Thread id is: " + id);
//    }
//
//    @Test
//    public void testMethodsTwo4() {
//        long id = Thread.currentThread().getId();
//        System.out.println("Simple test-method Two. Thread id is: " + id);
//    }
//
//        @AfterMethod
//        public void afterMethod() {
//        long id = Thread.currentThread().getId();
//        System.out.println("After test-method. Thread id is: " + id);
//    }
}
