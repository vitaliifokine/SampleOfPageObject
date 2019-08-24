package tests;

import dataProviders.Cities;
import dataProviders.Destinations;
import dataProviders.FootballClubs;
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
import java.util.*;

import static java.util.stream.Collectors.toMap;

public class GoogleSearchTestNotIncapsulated extends BaseTest{
//    Map<String, Integer> hmap = new HashMap<String, Integer>();
//    int counter = 0;
//
//    @Test
//    public void doGoogleSearch(){
//     SearchPage searchPage = new SearchPage(wd);
//     searchPage.openSearchPage()
//             .doSearchOf("Зеленский");
//    }
//
//    @Test
//    public void getButtonValidation(){
//        SearchPage searchPage = new SearchPage(wd);
//        String sample = searchPage.openSearchPage().getButtonNqame();
//        System.out.println(sample);
//    }
//
//    @Test
//    public void doGoogleSearchWithAnotherInput(){
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//                .doSearchOf("NBA starting date");
//        GoogleResultPage resultPage = new GoogleResultPage(wd);
//        Assert.assertEquals(resultPage.getFirstHeaderFromSearchPage(),
//                "Key dates for 2018-19 NBA season | NBA.com");
//    }
//
//    @Test()
//    public void searchAndOpenFirstLink(){
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//                .doSearchOf("LinkedIn")
//                .openFirstGoogleLink();
//    }
//
//    @Test
//    public void printGoogleHeaders(){
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//                .doSearchOf("LinkedIn")
//                .printTitlesInConsole();
//    }
//
//    @Test(dataProvider = "searchPages", dataProviderClass = SearchPages.class)
//        public void validateGoogleSearchHeaders(String searchItem, String expectedItem){
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//                .doSearchOf(searchItem)
//                .validateGoogleSearchHeaders(expectedItem);
//        }
//
//    @Test(dataProvider = "clubs", dataProviderClass = FootballClubs.class)
//    public void searchAndSortBySearchPopularity(String searchItem){
//        counter++;
//        SearchPage searchPage = new SearchPage(wd);
//        Integer quantity = searchPage.openSearchPage()
//                .doSearchOf(searchItem)
//                .getResultQuantityOfSearches();
//        hmap.put(searchItem, quantity);
//        if (FootballClubs.cities().length == counter){
//            this.after();
//        }
//    }
//
//    public void after(){
//        Map<String, Integer> u = hmap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
//                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
//                        LinkedHashMap::new));
//        int y= 1;
//        for (Map.Entry entry : u.entrySet()) {
//            System.out.println(y + ": " + entry.getKey() + ", " + entry.getValue());
//            y++;
//        }
//    }
//
//    @Test(dataProvider = "searchPages", dataProviderClass = SearchPages.class)
//    public void doGoogleSearch7(String volodya, String siteLinkVolodya){
//        wd.get("https://www.google.com");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(volodya);
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(wd, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
//        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        for(WebElement i: t) {
//            System.out.println(i.getText());
//        }
//        Assert.assertEquals(t.get(0).getText(), siteLinkVolodya);
//        t.get(0).click();
//    }
//
//    @Test(dataProvider = "cities", dataProviderClass = Cities.class)
//    public void doMapsSearch(String cities){
//        String searchedItem = cities;
//        wd.get("https://www.google.com");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(wd, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
//        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        t.get(0).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
//        wd.findElement(By.cssSelector("#searchboxinput")).sendKeys(searchedItem);
//        wd.findElement(By.cssSelector("#searchboxinput")).sendKeys(Keys.ENTER);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.section-hero-header-description > div:nth-child(1) > h1")));
//        Assert.assertEquals(wd.findElement(By.cssSelector("div.section-hero-header-description > div:nth-child(1) > h1")).getText(), searchedItem);
//    }
//
//
//
//    @Test(dataProvider = "Destinations", dataProviderClass = Destinations.class)
//    public void doMapsSearch2(String from, String to) throws IOException {
//        wd.get("https://www.google.com");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(wd, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
//        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        t.get(0).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
//        wd.findElement(By.cssSelector("#searchbox-directions")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sb_ifc51 > input")));
//        wd.findElement(By.cssSelector("#sb_ifc51 > input")).clear();
//        wd.findElement(By.cssSelector("#sb_ifc51 > input")).sendKeys(from);
//        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(to);
//        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(Keys.ENTER);
//        wd.findElement(By.cssSelector("div.directions-travel-mode-icon.directions-transit-icon")).click();
//        WebElement webElements = wd.findElement(By.cssSelector("div.section-directions-trip-numbers > div"));
//      //  captureScreenshot();
//            System.out.println("Using public transportation Currently from location: "+from+" to location: "+to+" is: "+webElements.getText());
//    }
//
//    @Test(dataProvider = "Destinations", dataProviderClass = Destinations.class)
//    public void doMapsSearch8(String from, String to) throws IOException, InterruptedException {
//        wd.get("https://www.google.com");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys("Google Maps");
//        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(wd, 15);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#logo > img")));
//        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
//        t.get(0).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#searchboxinput")));
//        wd.findElement(By.cssSelector("#searchbox-directions")).click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#sb_ifc51 > input")));
//        wd.findElement(By.cssSelector("#sb_ifc51 > input")).clear();
//        wd.findElement(By.cssSelector("#sb_ifc51 > input")).sendKeys(from);
//        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(to);
//        wd.findElement(By.cssSelector("#sb_ifc52 > input")).sendKeys(Keys.ENTER);
//        Thread.sleep(4000);
//        wd.findElement(By.cssSelector("div.directions-travel-mode-icon.directions-drive-icon")).click();
//        WebElement webElements = wd.findElement(By.cssSelector("div.section-directions-trip-numbers > div"));
//      //  captureScreenshot();
//        System.out.println("Using public transportation Currently from location: "+from+" to location: "+to+" is: "+webElements.getText());
//    }
//
//

    @Test()
    public void wordPressTest(String from, String to) throws IOException, InterruptedException {
        wd.get("http://localhost:8000/");
        WebDriverWait wait = new WebDriverWait(wd, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#masthead > div > div > h1 > a")));
        String text = wd.findElement(By.cssSelector("#masthead > div > div > h1 > a")).getText();
        System.out.println(text);
        captureScreenshot();
    }

}
