package tests;

import org.testng.annotations.Test;
import pages.SearchPage;

import java.util.Arrays;
import java.util.List;

public class GoogleRangeTest extends BaseTest{

    @Test
    public void searchAndSortBySearchPopularity(){
        List<String> searchInput = Arrays.asList("Dynamo Kyiv", "Real Madrid",
                "Manchester United", "Tottenham", "AC Milan", "Benfica");
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
              .sortByPopularity(searchInput);
    }

    @Test
    public void getStadium(){
        List<String> searchInput = Arrays.asList("Dynamo Kyiv", "Real Madrid",
                "Manchester United", "Tottenham", "AC Milan", "Benfica");
        SearchPage searchPage = new SearchPage(wd);
        searchPage.openSearchPage()
                .doSearchAndCheckCoach(searchInput);
    }
}
