package dataProviders;

import org.testng.annotations.DataProvider;

public class SearchPages {

    @DataProvider(name = "searchPages")
    public static Object[][] data()
    {
        return new Object[][] {  {"LinkedIn", "LinkedIn: Log In or Sign Up" },
                {"Google", "Google"},
                {"Facebook", "Facebook - Log In or Sign Up"},
                {"Zara", "ZARA United States | New Collection Online"},
                {"NBA results Lakers", "Los Angeles Lakers Basketball - Lakers News, Scores, Stats, Rumors ..."},
                {"Latest news", "ZARA United States | New Collection Online"},
                {"Dynamo Kyiv", "FC Dynamo Kyiv - Wikipedia"},
                {"Netflix", "Netflix - Watch TV Shows Online, Watch Movies Online"}};
    }
}
