package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.DriverFactory;

import java.util.concurrent.TimeUnit;

public class BaseTest extends DriverFactory

    {

        @BeforeTest
        public void setUp() {
        wd = DriverFactory.setBrowser("chrome");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

        @AfterTest
        public void quit() {
        wd.quit();
    }
}