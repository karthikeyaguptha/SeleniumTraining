package InterviewPrac.restassured;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

//MUST READ:
/*
Actually I commented this out but serialisation worked with no issues but deserialisation not worked and throwed an Error.
but why is it required for email but not for the id and name?

It didn't work for the email because Jackson relies on exact name matching between the JSON keys and your Java variable names.
Here is exactly why id and name worked perfectly, but email broke the moment you commented out @JsonProperty("email_address"):
## 1. Why id and name worked
Look at the JSON string coming back from the API:

{"id": 101, "name": "Alice Smith", "email_address": "alice@example.com"}


* The API sends a key named "id". Jackson looks at your Java class, finds a variable named id, and maps them together.
* The API sends a key named "name". Jackson finds a variable named name, and maps them together.
* Because the names match character-for-character, Jackson needs no extra help.

## 2. Why email failed
Your Java variable is named email, but the API is sending the data under the key "email_address".

* During Serialization: Java doesn't crash because Jackson just takes your variable name (email) and spits it out. However, if you checked the generated JSON, it would have output "email": "alice@example.com" instead of "email_address".
* During Deserialization: The API sends "email_address". Jackson looks at your Java class for a variable named exactly email_address. It cannot find one (it only sees email). Because it cannot map the key, it panics and throws an UnrecognizedPropertyException.

## The Purpose of @JsonProperty
The @JsonProperty("email_address") annotation acts as a translator translation bridge. It tells Jackson: "Hey, whenever you see a JSON key named email_address, map it to my Java variable named email."
Without that bridge, Jackson expects the names to be 100% identical.
------------------------------
If you want to completely get rid of @JsonProperty annotations but still handle keys like email_address safely, I can show you how to configure your ObjectMapper to globally handle snake_case naming or tell Jackson to ignore unmapped fields so it doesn't crash.
Would you like to see how to apply those global settings?

ObjectMapper mapper = new ObjectMapper()
    .setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE)
    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

 */

public class User {

    //Step 1: Define the Data Model (POJO)
    //Jackson relies on a standard Java class (Plain Old Java Object) with standard getters,
    // setters, and a no-argument constructor.

    private int id;
    private String name;

    @JsonProperty("email_addr") // Maps Java's camelCase to API's snake_case
    private String email;

    // Standard No-Argument Constructor (Required for Deserialization)
    public User() {

    }

    // Parameterized Constructor
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters (Required for Jackson to access fields)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //Step 2: Serialization (Java Object → JSON String)
    //When your API receives a request to fetch data, you take your Java User entity
    // and convert it to a JSON string to send back to the client.

    @Test
    public static void serialisationDemo() {
        // 1. Instantiate the Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        // 2. Create a mock Java Object
        User userData = new User(101, "Karthik", "karthik@qa.com");

        try {
            // 3. Serialize to a JSON String
            String jsonString = mapper.writeValueAsString(userData);
            System.out.println("--- Serialized JSON Output ---");
            System.out.println(jsonString);


        } catch (JsonProcessingException jpe) {
            System.out.println("Check the Class Format and then process JSON\n------------------------------------------" + jpe.getMessage());

        }

    }



    //Step 3: Deserialization (JSON String → Java Object)
    //When a client sends a POST request to your API containing a JSON body, you need to parse that JSON payload back into a Java User object.

    @Test
    public static void deSerialisationDemo()
    {
        // 1. Instantiate the Jackson ObjectMapper
        ObjectMapper mapper = new ObjectMapper();
        // 2. Mock JSON payload incoming from an API request
        String responseJSON = "{\"id\" : \"101\",\"name\" : \"karthik\",\"email_addr\" : \"karthik@qa.com\"}";
        // 3. Deserialize JSON back into a Java User object
        try {
            User user = mapper.readValue(responseJSON, User.class);
            System.out.println("--- Deserialized Java Object ---");
            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());

        }catch (JsonMappingException jme)
        {
            System.out.println("Check the JSON Format and then process\n------------------------------------------" + jme.getMessage());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}

