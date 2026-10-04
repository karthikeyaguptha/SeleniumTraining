package InterviewPrac.restassured;

import io.restassured.RestAssured;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;

public class APITest {


    @BeforeMethod
    public void setup()
    {
        // Set the base URL for the API endpoints
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    public void testGetSinglePost() {
        given()
                .header("Content-Type", "application/json") // Define request headers if needed
                .when()
                .get("/posts/2")                           // The endpoint path to test
                .then()
                .log().all()                                // Logs the full response payload to the console
                .statusCode(200)                            // Assert that status code is 200 OK
                .body("id", equalTo(2))                     // Assert that the 'id' field is 1
                .body("userId", equalTo(1));                // Assert that the 'userId' field is 1
    }

    @AfterMethod
    public void tearDown()
    {
        //Clean up or reset global settings after all tests in this class finish
        RestAssured.reset();
        System.out.println("Rest Assured configuration has been successfully reset.");
    }


}
