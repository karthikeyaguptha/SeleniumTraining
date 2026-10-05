package InterviewPrac.restassured;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.util.Map;

public class CarPOJO {


    private String carName;
    private String carMake;
    private int carYear;

    public CarPOJO()
    {

    }
    public CarPOJO(String carMake, String carName, int carYear) {
        this.carMake = carMake;
        this.carName = carName;
        this.carYear = carYear;
    }

    public String getCarMake() {
        return carMake;
    }

    public void setCarMake(String carMake) {
        this.carMake = carMake;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public int getCarYear() {
        return carYear;
    }

    public void setCarYear(int carYear) {
        this.carYear = carYear;
    }


    @Test
    public void serialisationDemo()
    {
        ObjectMapper mapper = new ObjectMapper();

        CarPOJO carPOJO = new CarPOJO("Mahindra","3X0",2025);

        try {
            String jsonString = mapper.writeValueAsString(carPOJO);
            System.out.println("--- Serialized JSON Output ---");
            System.out.println(jsonString);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void deSerialisationDemo()
    {
        ObjectMapper mapper = new ObjectMapper();
        String responseJson = "{\"carMake\" : \"Mahindra\",\"carName\" : \"3X0\",\"carYear\" : \"2025\" }";

        try {
            CarPOJO carPOJO = mapper.readValue(responseJson, CarPOJO.class);
            System.out.println("--- DeSerialized JSON Output ---");
            Map<String,Object> carpojo = mapper.readValue(responseJson, Map.class);
            for (Map.Entry<String, Object> stringObjectEntry : carpojo.entrySet()) {
                System.out.println(stringObjectEntry.getKey() +":"+stringObjectEntry.getValue());
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
