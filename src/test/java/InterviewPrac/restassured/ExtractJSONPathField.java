package InterviewPrac.restassured;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ExtractJSONPathField {


    @BeforeTest
    public void setUp()
    {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }
    @AfterTest
    public void tearDown()
    {
        RestAssured.reset();
        System.out.println("Rest Assured configuration has been successfully reset.");
    }

    @Test
    public void getFieldValuesExtracted() {
        Response response = given()
                .header("Content-Type","application/json")
                .accept("json")
                .when()
                .get("/posts/1");
        System.out.println("--- Response Body Starts ---");
        System.out.println(response.asPrettyString());
        System.out.println("--- Response Body Ends ---");
        int userId = response.jsonPath().getInt("userId");
        int id = response.jsonPath().getInt("id");
        String title = response.jsonPath().getString("title");
        String body = response.jsonPath().getString("body");

        // Printing all extracted values:
        System.out.println("Extracted User ID : "+ userId);
        System.out.println("Extracted ID : "+ id);
        System.out.println("Extracted title : "+ title);
        System.out.println("Extracted body : "+ body);

        //Assertions
        response.then()
                .statusCode(200)
                .body("userId" , equalTo(1))
                .body("id", equalTo(1))
                .body("title",equalTo("sunt aut facere repellat provident occaecati excepturi optio reprehenderit"))
                .body("body",equalTo("quia et suscipit\n" +
                        "suscipit recusandae consequuntur expedita et cum\n" +
                        "reprehenderit molestiae ut ut quas totam\n" +
                        "nostrum rerum est autem sunt rem eveniet architecto"));



    }

}
