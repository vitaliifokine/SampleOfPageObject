package tests;

import org.testng.annotations.Test;
import pages.BasePage;

import java.io.IOException;

public class SampleTest extends BaseTest {

    @Test()
    public void testGuruCom() throws IOException {
        wd.get("https://www.guru99.com");
        captureScreenshot(wd);
    }

    @Test()
    public void testWikipedia() throws IOException {
        wd.get("https://en.wikipedia.org/wiki/Wiki");
        captureScreenshot(wd);
    }

    @Test()
    public void testCucumber() throws IOException {
        new BasePage(wd).openWebPage("https://cucumber.io/docs/guides/10-minute-tutorial/");
        captureScreenshot(wd);
    }


    @Test()
    public void testUnitedNations() throws IOException {
        wd.get("https://www.un.org/en/");
        captureScreenshot(wd);
        saveScreenshot();
    }
}