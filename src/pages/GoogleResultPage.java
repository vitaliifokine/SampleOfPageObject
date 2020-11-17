package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class GoogleResultPage extends BasePage{
    @FindBy (css = ".LC20lb")
    List<WebElement> searchResultsHeaders;

    @FindBy (css = "h3.LC20lb")
    List<WebElement> searchResultsHeaderLines;

    @FindBy (css = "#search h3.LC20lb")
    List<WebElement> headerDescription;

    @FindBy (css = "#topabar #resultStats")
    WebElement resultsQuantity;

    @FindBy (css = "#logo > img")
    WebElement logoResultPage;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnLinkByValue(int linkValue){
         searchResultsHeaders.get(linkValue).click();
    }

    public String getFirstHeaderFromSearchPage(){
        return searchResultsHeaders.get(0).getText();
    }

    public GoogleResultPage openFirstGoogleLink (){

        searchResultsHeaderLines.get(0).click();
        return this;
    }

    public void printTitlesInConsole() {
        List<WebElement> t = headerDescription;
        for (WebElement i : t) {
            System.out.println(i.getText());
        }
        t.get(0).click();
    }

    public void validateGoogleSearchHeaders(String expectedItem) {
        List<WebElement> t = wd.findElements(By.cssSelector("#search h3.LC20lb"));
        for (WebElement i : t) {
            System.out.println(i.getText());
        }
        Assert.assertEquals(t.get(0).getText(), expectedItem);
        t.get(0).click();
    }

    public Integer getResultQuantityOfSearches(){
        return Integer.parseInt(resultsQuantity.getText().split(" ")[1]
                .replace(",", ""));
    }


    public void openFirstLink(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(logoResultPage));
        headerDescription.get(0).click();
    }

}
