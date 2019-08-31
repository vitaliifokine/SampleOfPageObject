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

public class Thread3 extends BaseTest {

    // Succesfully done
    @Test()
    public void dockerSeleniumHub() throws IOException {
//        >java -jar selenium-server-standalone-3.141.59.jar -role hub
//                > java -jar selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register
//
//        Node Start Command with Chrome Driver Location: java -jar -Dwebdriver.chrome.driver=C:\Users\Julia_Kolesnyk\IdeaProjects\SampleOfPageObject2\chromedriver.exe selenium-server-standalone-3.141.59.jar -role node -hub http://localhost:4444/grid/register
        try {
            executeGrid("https://www.guru99.com");
        } catch (SessionNotCreatedException sessionNotCreatedException){
            executeGrid("https://www.guru99.com");
        }
    }

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
    }

}
