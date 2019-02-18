package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

import static java.util.stream.Collectors.toMap;

public class SearchPage extends BasePage {
    Map<String, Integer> hmap = new HashMap<String, Integer>();

    @FindBy(css = "div.a4bIc > input")
    private WebElement searchInput;

    @FindBy(css = "#logo > img")
    private WebElement searchResultLogo;

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public SearchPage openSearchPage(){
        wd.get("https://www.google.com");
        return this;
    }

    public void  sortByPopularity(List<String> values){
        Map<String, Integer> results = getSortedResults(values);
        print(results);
    }

    public GoogleResultPage doSearchOf(String searchText){
        searchInput.clear();
        searchInput.sendKeys(searchText);
        searchInput.sendKeys(Keys.ENTER);
        waitUntilDisplayedBy(searchResultLogo);
        return new GoogleResultPage(wd);
    }

    public void  getSearchedText(String searchText){
        searchInput.getText();
    }

    private Map<String, Integer> getSortedResults(List<String> values){
        for (String i:values) {
            Integer value = doSearchOf(i)
                    .getResultQuantityOfSearches();
            hmap.put(i, value);
        }
        return hmap.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2,
                        LinkedHashMap::new));
    }

    private void  print(Map<String, Integer> u){
        int y= 1;
        for (Map.Entry entry : u.entrySet()) {
            System.out.println(y + ": " + entry.getKey() + ", " + entry.getValue());
            y++;
    }}

}