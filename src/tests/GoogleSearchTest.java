package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ResultPage;
import pages.SearchPage;

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

    @Test
    public void doGoogleSearch2(){
        System.setProperty("chromedriver", "/Users/juliakolesnyk/Desktop/LessonSample/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("LinkedIn");
        driver.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
    }
}
