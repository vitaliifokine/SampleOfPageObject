package tests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.List;

public class RestAPITests {

    @Test
    public void GetWeatherDetailsCondensed()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city";
        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();
        // Make a GET request call directly by using RequestSpecification.get() method.
        // Make sure you specify the resource name.
        Response response = httpRequest.get("/Hyderabad");

        // Response.asString method will directly return the content of the body
        // as String.
        System.out.println("Response Body is =>  " + response.asString());
    }

    @Test
    public void sampleTest() {
        RestAssured.baseURI = "http://api.nobelprize.org";
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get("/v1/laureate.json");
        JsonPath jsonPathEvaluator = response.jsonPath();
        List<String> firstNamesOfAllLaureates = jsonPathEvaluator.getList("laureates.firstname");
        List<String> lastNamesOfAllLaureates = jsonPathEvaluator.getList("laureates.surname");
        List<String> died = jsonPathEvaluator.getList("laureates.diedCountry");
        System.out.println(response.asString());
    }

//
//    @Test
//    public void searchAndSortBySearchPopularity(){
//        List<String> searchInput = Arrays.asList("Dynamo Kyiv", "Real Madrid",
//                "Manchester United", "Tottenham", "AC Milan", "Benfica");
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//              .sortByPopularity(searchInput);
//    }
//
//    @Test
//    public void getStadium(){
//        List<String> searchInput = Arrays.asList("Dynamo Kyiv", "Real Madrid",
//                "Manchester United", "Tottenham", "AC Milan", "Benfica");
//        SearchPage searchPage = new SearchPage(wd);
//        searchPage.openSearchPage()
//                .doSearchAndCheckCoach(searchInput);
//    }
}
