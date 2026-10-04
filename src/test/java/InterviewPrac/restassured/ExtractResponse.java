package InterviewPrac.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ExtractResponse {

    @BeforeMethod
    public void setUp()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @AfterMethod
    public void tearDown()
    {
        RestAssured.reset();
        System.out.println("Rest Assured configuration has been successfully reset.");
    }


    @Test
    public void getEntireResponse() {
        given()
                .header("Content-Type", "application/json")
                .accept("json")
                .when()
                .get("/posts/1")
                .then()
                .log().all()
                .statusCode(200)
                .body("id",equalTo(1));
    }

    @Test
    public void getBodyResponse()
    {
        given()
                .header("Content-Type","appliation/json")
                .accept("json")
                .when()
                .get("/posts/1")
                .then()
                .log().body()
                .statusCode(200);
    }

    @Test
    public void getHeadersResponse()
    {
        given()
                .header("Content-Type","application/json")
                .accept("json")
                .when()
                .get("/posts/1")
                .then()
                .log().headers()
                .statusCode(200);
    }

    @Test
    public void getResponseAsString()
    {
        Response response = given()
                .header("Content-Type" ,"application/json")
                .accept("json")
                .when()
                .get("/posts/1");

        // Option A: Prints it exactly as received (flat string)
        System.out.println(response.asString());

        // Option B: Formats the JSON nicely with indents (Recommended)
        System.out.println(response.asPrettyString());
    }



}
