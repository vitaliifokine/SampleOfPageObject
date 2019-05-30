package dataProviders;

import org.testng.annotations.DataProvider;

public class Destinations {

    @DataProvider(name = "Destinations")
    public static Object[][] destinations() {
        return new Object[][] {
                {"Newark", "Hoboken"},
                {"Brighton Beach", "Times Square"}
        };
    }
}
