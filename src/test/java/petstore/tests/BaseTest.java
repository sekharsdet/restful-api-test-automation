package petstore.tests;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class BaseTest {
    private final String BASE_URI = "http://localhost:8080/api/v3";

    protected String getBaseUri(){
        return BASE_URI;
    }

    protected String pojoToJson(Object object){
        ObjectMapper mapper=new ObjectMapper() ;
        try {
            return mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}