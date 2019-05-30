package dataProviders;

import org.testng.annotations.DataProvider;

public class Cities {
    @DataProvider(name = "cities")
    public static Object[][] cities() {
        return new Object[][] {
                {"Донецк" },
                {"Tokyo"},
                {"London"},
                {"Kyiv"},
                {"Los Angeles"},
                {"Philadelphia"},
                {"Jersey City"},
                {"Berlin"},
                {"Madrid"}
        };
    }
}
