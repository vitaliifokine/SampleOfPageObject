package tests;

import io.qameta.allure.Allure;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;

public class SampleTest extends BaseTest {

    @Test(description = "Guru 99")
    public void testGuruCom() throws IOException {
        wd.get("https://www.guru99.com");
        captureScreenshot(wd);
    }

    @Test()
    public void testWikipedia() throws IOException {
        wd.get("https://en.wikipedia.org/wiki/Wiki");
        captureScreenshot(wd);
    }

    @Test(description = "Check Cucumber")
    public void testCucumber() throws IOException {
        new BasePage(wd).openWebPage("https://cucumber.io/docs/guides/10-minute-tutorial/");
        captureScreenshot(wd);
    }


    @Feature("Sample")
    @Test(description = "Test")
    public void testUnitedNations() throws IOException {
        wd.get("https://www.un.org/en/");
        captureScreenshot(wd);
    }
}