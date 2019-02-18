package tests;

import dataProviders.Cities;
import dataProviders.Destinations;
import dataProviders.SearchPages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoogleResultPage;
import pages.SearchPage;

import java.io.IOException;
import java.util.List;

public class GoogleSearchTest extends BaseTest{

    @Test
    public void doGoogleSearch(){
     SearchPage searchPage = new SearchPage(wd);
     searchPage.openSearchPage()
             .doSearchOf("Last News");
    }

    @Test
    public void doGoogleSearchWithAnotherInput(){
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchOf("NBA starting date");
        GoogleResultPage resultPage = new GoogleResultPage(wd);
        Assert.assertEquals(resultPage.getFirstHeaderFromSearchPage(),
                "Key dates for 2018-19 NBA season | NBA.com");
    }

    @Test()
    public void searchAndOpenFirstLink(){
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchOf("LinkedIn")
                .openFirstGoogleLink();
    }

    @Test
    public void printGoogleHeaders(){
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchOf("LinkedIn")
                .printTitlesInConsole();
    }


    @Test(dataProvider = "searchPages", dataProviderClass = SearchPages.class)
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

    @Test(dataProvider = "searchPages", dataProviderClass = SearchPages.class)
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

    @Test(dataProvider = "cities", dataProviderClass = Cities.class)
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



    @Test(dataProvider = "Destinations", dataProviderClass = Destinations.class)
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
