package tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class RandomFactAPITest {
    private final String baseUrl = "https://cat-fact.herokuapp.com";
    private final String endpoint = "/facts/random";

    @Test
    public void tc04_testGetRandomCatFact() {
        Response response = RestAssured.given()
                .baseUri(baseUrl)
                .queryParam("animal_type", "cat")
                .queryParam("amount", 1)
                .when()
                .get(endpoint);

        // Validate response structure and types
        response.then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("[0].text", not(emptyString()));
    }
}
