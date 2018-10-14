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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

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
        return new Object[][] {
                {"LinkedIn", "LinkedIn: Log In or Sign Up" },
                {"Google", "Google"},
                {"Facebook", "Facebook - Log In or Sign Up"},
                {"Netflix", "Netflix - Watch TV Shows Online, Watch Movies Online"}
        };
    }

    @Test(dataProvider = "Authentication")
        public void doGoogleSearch6(String searchItem, String expectedItem){
            System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
            WebDriver driver = new ChromeDriver();
            driver.get("https://www.google.com");
            driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(searchItem);
            driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
            List<WebElement> t = driver.findElements(By.cssSelector("#search h3.LC20lb"));
            for(WebElement i: t) {
                System.out.println(i.getText()); }
            Assert.assertEquals(t.get(0).getText(), expectedItem);
            t.get(0).click();
        }

    @Test(dataProvider = "Authentication")
    public void doGoogleSearch7(String volodya, String siteLinkVolodya){
        System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(volodya);
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
        List<WebElement> t = driver.findElements(By.cssSelector("#search h3.LC20lb"));
        for(WebElement i: t) {
            System.out.println(i.getText());
        }
        Assert.assertEquals(t.get(0).getText(), siteLinkVolodya);
        t.get(0).click();
    }
}
