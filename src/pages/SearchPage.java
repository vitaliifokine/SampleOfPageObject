package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {
    @FindBy(css = "div.a4bIc > input")
    private WebElement searchInput;


    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage openSearchPage(){
        wd.get("https://www.google.com");
        return this;
    }

    public ResultPage doSearchWithInput(String searchText){
        searchInput.sendKeys(searchText);
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(searchText);
        wd.findElement(By.cssSelector("div.a4bIc > input")).sendKeys(Keys.ENTER);
        return new ResultPage(wd);
    }

    public void  getSearchedText(String searchText){
        searchInput.getText();

    }

}
