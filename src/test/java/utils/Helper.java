package utils;

import exception.StringToJsonConversionException;
import io.restassured.path.json.JsonPath;

public class Helper {

    public static JsonPath toJson(String payload){
        if(payload == null || payload.isBlank()){
            throw new StringToJsonConversionException("Cannot convert null or empty payload to JSON");
        }
        return new JsonPath(payload);
    }

    public static Object get(String payload,String key){
        JsonPath response = toJson(payload);
        return response.get(key);
    }
}
