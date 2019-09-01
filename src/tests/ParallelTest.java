package tests;

import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class ParallelTest extends BaseTest {


//    @Test()
//    public void dockerSeleniumHub1() throws MalformedURLException {
//        // DockerHub
////        Use below commands to run Grid:
////        $ docker run -d -p 4444:4444 --name selenium-hub selenium/hub:3.4.0
////        $ docker run -d --link selenium-hub:hub selenium/node-chrome:3.4.0
////        $ docker run -d --link selenium-hub:hub selenium/node-firefox:3.4.0
//        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//
//        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
//        desiredCapabilities.setPlatform(Platform.WIN10);
//        desiredCapabilities.setBrowserName("chrome");
//        ChromeOptions chromeOptions = new ChromeOptions();
//       // chromeOptions.addArguments("disable-infobars");
//        chromeOptions.merge(desiredCapabilities);
//        chromeOptions.addArguments("--allow-file-access-from-files"); /*Allow Chrome to access files*/
//        chromeOptions.addArguments("user-data-dir="+System.getProperty("webdriver.chrome.driver")+"chromedriver.exe");
//        desiredCapabilities.setBrowserName("chrome");
//        desiredCapabilities.setCapability(ChromeOptions.CAPABILITY, desiredCapabilities);
//        WebDriver driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), chromeOptions);
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//
//        driver.get("https://www.guru99.com");
//        driver.quit();
//
//
//    }

    // Succesfully done
    @Test()
    public void dockerSeleniumHub() throws IOException {
//        >java -jar selenium-server-standalone-3.141.59.jar -role hub
//                > java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register
//
//        Node Start Command with Chrome Driver Location: java -jar -Dwebdriver.chrome.driver=C:\Users\Julia_Kolesnyk\IdeaProjects\SampleOfPageObject2\chromedriver.exe selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register
        try {
           executeGrid("https://stackoverflow.com");
        } catch (SessionNotCreatedException sessionNotCreatedException){
            executeGrid("https://stackoverflow.com");
        }
    }


//    @Test()
//    public void dockerSeleniumHub2() throws MalformedURLException {
//        DesiredCapabilities capability = DesiredCapabilities.chrome();
//        WebDriver driver;
//        String nodeUrl = "http://172.17.0.3:4444/wd/hub";
//        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
//        capabilities.setBrowserName("chrome");
//        capabilities.setPlatform(Platform.getCurrent());
//        driver = new RemoteWebDriver(new ChromeOptions());
//        driver.manage().deleteAllCookies();
//        // driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//        driver.manage().timeouts().pageLoadTimeout(45, TimeUnit.SECONDS);
//        driver.get("https://www.google.co.in/");
//
//    }

    private void executeGrid(String grid) throws IOException {
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
        driver.get(grid);
        driver.quit();
        Runtime.getRuntime().exec("TASKKILL /IM chromedriver.exe /F");
        System.out.println("V2");
        System.out.println("Test Case One with Thread Id:- "
                + Thread.currentThread().getId());
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
