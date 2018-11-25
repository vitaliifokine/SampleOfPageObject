package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

import java.io.IOException;
import java.util.List;

public class GoogleSearchTest extends BaseTest{

    @Test
    public void doGoogleSearch(){
     SearchPage searchPage = new SearchPage(wd);
     searchPage.openSearchPage()
             .doSearchWithInput("Last News");
    }

    @Test
    public void doGoogleSearchWithAnotherInput(){
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchWithInput("NBA starting date");
        ResultPage resultPage = new ResultPage(wd);
        Assert.assertEquals(resultPage.getFirstHeaderFromSearchPage(),
                "Key dates for 2018-19 NBA season | NBA.com");
    }

    @Test(enabled = false)
    public void doGoogleSearch2(){
        System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("LinkedIn");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        driver.findElements(By.cssSelector("h3.LC20lb")).get(0).click();
        System.out.println();
    }

    @Test
    public void doGoogleSearch3(){
        System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("LinkedIn");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = driver.findElements(By.cssSelector("#search h3.LC20lb"));
        for(WebElement i: t) {
            System.out.println(i.getText());
        }
        t.get(0).click();
    }


    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        String siteForSearch = "LinkedIn";
        return new Object[][] {
                {siteForSearch, "LinkedIn: Log In or Sign Up" },
                {"Google", "Google"},
                {"Facebook", "Facebook - Log In or Sign Up"},
                {"Zara", "ZARA United States | New Collection Online"},
                {"NBA results Lakers", "ZARA United States | New Collection Online"},
                {"NBA results Lebron", "ZARA United States | New Collection Online"},
                {"Latest news", "ZARA United States | New Collection Online"},
                {"Dynamo Kyiv", "ZARA United States | New Collection Online"},
                {"Netflix", "Netflix - Watch TV Shows Online, Watch Movies Online"}
        };
    }

    @Test(dataProvider = "Authentication", enabled = true)
        public void doGoogleSearch6(String searchItem, String expectedItem){
            wd.get("https://www.google.com");
            wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(searchItem);
            wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(wd, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
            List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
            for(WebElement i: t) {
                System.out.println(i.getText()); }
            Assert.assertEquals(t.get(0).getText(), expectedItem);
            t.get(0).click();
        }

    @Test(dataProvider = "Authentication", description = "searchTest")
    public void doGoogleSearch7(String volodya, String siteLinkVolodya){
        wd.get("https://www.google.com");
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(volodya);
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
        for(WebElement i: t) {
            System.out.println(i.getText());
        }
        Assert.assertEquals(t.get(0).getText(), siteLinkVolodya);
        t.get(0).click();
    }


    @DataProvider(name = "Cities")
    public static Object[][] cities() {
        return new Object[][] {
                {"Boston" },
                {"Tokyo"},
                {"London"},
                {"Washington"},
                {"Los Angeles"},
                {"Philadelphia"},
                {"Jersey City"},
                {"Berlin"},
                {"Madrid"}
        };
    }

    @Test(dataProvider = "Cities", description = "map verification")
    public void doMapsSearch(String cities){
        String searchedItem = cities;
        wd.get("https://www.google.com");
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
        t.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
        wd.findElement(By.cssSelector("#searchboxinput")).sendKeys(searchedItem);
        wd.findElement(By.cssSelector("#searchboxinput")).sendKeys(Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section-hero-header-description > div:nth-child(1) > h1")));
        Assert.assertEquals(wd.findElement(By.cssSelector("div.section-hero-header-description > div:nth-child(1) > h1")).getText(), searchedItem);
    }

    @DataProvider(name = "Destinations")
    public static Object[][] destinations() {
        return new Object[][] {
                {"Journal Square", "Hoboken"},
                {"Journal Square", "Times Square"}
        };
    }

    @Test(dataProvider = "Destinations", description = "Provide search")
    public void doMapsSearch2(String from, String to) throws IOException {
        wd.get("https://www.google.com");
        wd.findElement(By.cssSelector("")).sendKeys("Google Maps");
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(wd, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
        t.get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
        wd.findElement(By.cssSelector("#searchbox-directions")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sb_ifc51 > input")));
        wd.findElement(By.cssSelector("#sb_ifc51 > input")).sendKeys(from);
        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(to);
        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(Keys.ENTER);
        wd.findElement(By.cssSelector("div.directions-travel-mode-icon.directions-transit-icon")).click();
        WebElement webElements = wd.findElement(By.cssSelector("div.section-directions-trip-numbers > div"));
        captureScreenshot();
            System.out.println("Using public transportation Currently from location: "+from+" to location: "+to+" is: "+webElements.getText());
    }
}
