package tests;

import org.testng.annotations.Test;

import java.io.IOException;

public class SampleTest extends BaseTest {

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
}