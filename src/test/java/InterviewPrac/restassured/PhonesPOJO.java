package InterviewPrac.restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Map;

public class PhonesPOJO {

    private String phoneCompany;
    private String phoneName;
    private int phoneYear;

    public PhonesPOJO()
    {

    }

    public PhonesPOJO(String phoneCompany,String phoneName,int phoneYear){
        this.phoneCompany = phoneCompany;
        this.phoneName = phoneName;
        this.phoneYear = phoneYear;
    }

    public String getPhoneCompany() {
        return phoneCompany;
    }

    public void setPhoneCompany(String phoneCompany) {
        this.phoneCompany = phoneCompany;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public int getPhoneYear() {
        return phoneYear;
    }

    public void setPhoneYear(int phoneYear) {
        this.phoneYear = phoneYear;
    }

    @Test
    public void serialisationDemo()
    {
        ObjectMapper mapper = new ObjectMapper();
        PhonesPOJO phonesPOJO = new PhonesPOJO("Apple","iPhone17",2025);

        try {
            String jsonString = mapper.writeValueAsString(phonesPOJO);
            System.out.println("--- Serialising Object ---");
            System.out.println(jsonString);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

    @Test
    public void deSerialisationDemo()
    {
        ObjectMapper mapper = new ObjectMapper();
        String responseObj = "{\"phoneCompany\" : \"Samsung\",\"phoneName\" : \"S25Ultra\",\"phoneYear\" : \"2025\"}";

        try {
            Map<String,Object> phonesPOJO = mapper.readValue(responseObj, Map.class);
            System.out.println("--- De-Serialising Object ---");
            for (Map.Entry<String,Object> entry : phonesPOJO.entrySet())
            {
                System.out.println(entry.getKey() + " : "+entry.getValue());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }




}
