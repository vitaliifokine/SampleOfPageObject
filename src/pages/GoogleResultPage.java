package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class GoogleResultPage extends BasePage{
    @FindBy (css = ".LC20lb")
    List<WebElement> searchResultsHeaders;

    @FindBy (css = "h3.LC20lb")
    List<WebElement> searchResultsHeaderLines;

    @FindBy(css = "#logo > img")
    private WebElement searchResultLogo;

    public GoogleResultPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnLinkByValue(int linkValue){
         searchResultsHeaders.get(linkValue).click();
    }

    public String getFirstHeaderFromSearchPage(){
        return searchResultsHeaders.get(0).getText();
    }

    public void openFirstGoogleLink (){
        waitUntilDisplayedBy(searchResultLogo);
        searchResultsHeaderLines.get(0).click();
    }
}
