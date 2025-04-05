package utils;

import exception.StringToJsonConversionException;
import io.restassured.path.json.JsonPath;

public class Helper {
    ExcelUtil util;
    public Helper(){
        String FilePath = System.getProperty("testDataFilePath");

        util = new ExcelUtil(FilePath,0);

    }

    public String read(String key){
        return util.readFromExcel(key).toString();
    }

    public void write(String key, String newValue){
        util.writeInExcel(key,newValue);
    }

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
