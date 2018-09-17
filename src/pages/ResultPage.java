package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ResultPage extends BasePage{
    @FindBy (css = ".LC20lb")
    List<WebElement> searchResultsHeaders;


    public ResultPage(WebDriver driver) {
        super(driver);
    }


    public void clickOnLinkByValue(int linkValue){
         searchResultsHeaders.get(linkValue).click();
    }

    public String getFirstHeaderFromSearchPage(){
        return searchResultsHeaders.get(0).getText();
    }
}
