package InterviewPrac.restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class UserPrac {


    private int id;
    private String name;
    private String email;

    public UserPrac() {
    }

    public UserPrac(int id, String name, String email) {
        this.id = id;
        this.email = email;
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Test
    public static void serialisationDemo() {
        // Initialize the Object Mapper
        ObjectMapper mapper = new ObjectMapper();

        //Mock the Java Object
        UserPrac userPrac = new UserPrac(101, "KarthikeyaGuptha", "karthik@gmail.com");

        // Serialize to JSON String
        try {
            String jsonString = mapper.writeValueAsString(userPrac);
            System.out.println("--- Serialized JSON Output ---");
            System.out.println(jsonString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    @Test
    public static void deSerialisationDemo() {
        // Initialize the Object Mapper
        ObjectMapper mapper = new ObjectMapper();
        //Mock the JSON Object
        String jsonResponse = "{ \"id\" : \"101\" ,\"name\" : \"Karthik Guptha\" ,\"email\" : \"Karthik@gmail.con\" }";
        //Deserialize to JAVA Object
        try {
            UserPrac userPrac = mapper.readValue(jsonResponse, UserPrac.class);
            System.out.println("--- DeSerialized JSON Output ---");
            System.out.println("ID :" + userPrac.getId());
            System.out.println("Name :" + userPrac.getName());
            System.out.println("Email :" + userPrac.getEmail());

        } catch (Exception e) {
            System.out.println(e.getMessage());


        }
    }
}
