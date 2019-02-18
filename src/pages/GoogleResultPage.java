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

    @FindBy (css = "#search h3.LC20lb")
    List<WebElement> headerDescription;

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
}
