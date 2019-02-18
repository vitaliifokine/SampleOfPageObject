package dataProviders;

import org.testng.annotations.DataProvider;

public class FootballClubs {
    @DataProvider(name = "clubs")
    public static Object[][] cities() {
        return new Object[][] {
                {"Dynamo Kyiv" },
                {"Real Madrid"},
                {"Manchester United"}
        };
    }
}
